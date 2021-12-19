package ru.restaurant.authentication.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.restaurant.db.dao.Role;
import ru.restaurant.db.dao.User;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return JwtUser.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .authorities(mapToGrantedAuthorities(user.getRoles()))
                .enabled(Boolean.TRUE)
                .password(user.getPassword())
                .username(user.getUsername())
                .build();
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(roleDto ->
                        new SimpleGrantedAuthority(roleDto.getName())
                ).collect(Collectors.toList());
    }
}
