package ru.restaurant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.restaurant.db.dao.User;
import ru.restaurant.db.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtUserService {
    private final UserRepository userRepository;

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
