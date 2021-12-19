package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.restaurant.authentication.security.jwt.JwtTokenProvider;
import ru.restaurant.authentication.security.jwt.JwtUser;
import ru.restaurant.db.dao.User;
import ru.restaurant.db.repository.UserRepository;
import ru.restaurant.dto.AuthenticationRequestDto;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder encoder;
    private final JwtUserService jwtUserService;


    public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public ResponseEntity login(AuthenticationRequestDto requestDto) {
        String login = requestDto.getLogin();
        String pass = requestDto.getPassword();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, pass));
            User user = jwtUserService.findByLogin(login);
            if (user == null) {
                throw new UsernameNotFoundException("User with login: " + login + " not found");
            }
            String token = jwtTokenProvider.createToken(login, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", login);
            response.put("token", token);
            response.put("roles", user.getRoles());
            response.put("email", user.getEmail());
            response.put("firstname", user.getFirstName());
            response.put("lastname", user.getLastName());

            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            log.info("User with login: " + login + " not authenticated");
            return ResponseEntity.status(UNAUTHORIZED).body("not authenticated");
        } catch (AuthenticationException e) {
            log.info("User with login: " + login + " not found");
            return ResponseEntity.status(UNAUTHORIZED).body("not found");
        }
    }

    public ResponseEntity getUserByToken(String bearerToken) {
        try {
            JwtUser jwtUser = null;
            User user = null;
            String token = jwtTokenProvider.resolveToken(bearerToken);
            if (token != null && jwtTokenProvider.validateToken(token)) {
                Authentication auth = jwtTokenProvider.getAuthentication(token);
                jwtUser = (JwtUser) auth.getPrincipal();
                user = jwtUserService.findByLogin(jwtUser.getUsername());

                if (user == null) {
                    log.info("User with login: " + jwtUser.getUsername() + " not found");
                    throw new UsernameNotFoundException("User with login: " + jwtUser.getUsername() + " not found");
                }
            }

            Map<Object, Object> response = new HashMap<>();
            response.put("username", jwtUser.getUsername());
            response.put("token", token);
            response.put("roles", user.getRoles());
            response.put("email", user.getEmail());
            response.put("firstname", user.getFirstName());
            response.put("lastname", user.getLastName());

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(UNAUTHORIZED).body("Error");
        }
    }
}