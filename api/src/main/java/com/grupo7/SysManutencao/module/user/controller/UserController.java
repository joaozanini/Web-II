package com.grupo7.SysManutencao.module.user.controller;

import com.grupo7.SysManutencao.module.user.dto.UserRequest;
import com.grupo7.SysManutencao.module.user.dto.UserResponse;
import com.grupo7.SysManutencao.module.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponse> signup(@Valid @RequestBody UserRequest request) {
        UserResponse response = service.signup(request);
        return ResponseEntity.status(201).body(response);
    }
}
