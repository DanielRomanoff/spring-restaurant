package ru.restaurant.dto;

public class AuthenticationRequestDto implements Dto {
    private String login;
    private String password;

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }
}
