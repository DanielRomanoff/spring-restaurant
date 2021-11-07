package ru.restaurant.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.restaurant.db.dao.User;
import ru.restaurant.dto.UserDto;

@Service
@AllArgsConstructor
public class UserMapper implements Mapper<UserDto, User> {
    private final RoleMapper roleMapper;

    @Override
    public UserDto mapToDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .roles(roleMapper.mapToDto(entity.getRoles()))
                .login(entity.getUsername())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }

    @Override
    public User mapToEntity(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .roles(roleMapper.mapToEntity(dto.getRoles()))
                .username(dto.getLogin())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
}
