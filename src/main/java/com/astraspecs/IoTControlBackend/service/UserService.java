package com.astraspecs.IoTControlBackend.service;

import com.astraspecs.IoTControlBackend.repository.UserRepository;
import com.astraspecs.IoTControlBackend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
