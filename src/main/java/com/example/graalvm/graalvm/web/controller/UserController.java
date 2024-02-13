package com.example.graalvm.graalvm.web.controller;


import com.example.graalvm.graalvm.exception.UserNotFoundException;
import com.example.graalvm.graalvm.model.User;
import com.example.graalvm.graalvm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

}
