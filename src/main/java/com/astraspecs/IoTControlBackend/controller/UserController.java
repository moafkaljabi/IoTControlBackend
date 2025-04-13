package com.astraspecs.IoTControlBackend.controller;

import com.astraspecs.IoTControlBackend.service.UserService;
import com.astraspecs.IoTControlBackend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("/{email}")
    public User getUser(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
