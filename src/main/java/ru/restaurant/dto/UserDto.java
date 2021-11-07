package ru.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Dto {
    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<RoleDto> roles;
}
