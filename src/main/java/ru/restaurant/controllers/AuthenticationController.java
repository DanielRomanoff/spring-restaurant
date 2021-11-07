package ru.restaurant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.dto.AuthenticationRequestDto;
import ru.restaurant.dto.UserDto;
import ru.restaurant.mappers.UserMapper;
import ru.restaurant.services.UserService;

@Slf4j
@RequiredArgsConstructor
@RestController
@SuppressWarnings("rawtypes")
@RequestMapping(value = "/auth")
public class AuthenticationController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        log.info("trying to login with = {}", requestDto);
        return userService.login(requestDto);
    }

    @PostMapping("/user")
    public ResponseEntity getUserByToken(@RequestHeader("Authorization") String bearerToken) {
        log.info("get user by token = {}", bearerToken);
        return userService.getUserByToken(bearerToken);
    }

    @PostMapping("/create")
    @PreAuthorize("permitAll()")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        log.info("create user = {}", userDto);
        return ResponseEntity.ok(userMapper.mapToDto(userService.createUser(userMapper.mapToEntity(userDto))));
    }
}