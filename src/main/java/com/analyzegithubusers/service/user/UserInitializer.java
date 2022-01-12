package com.analyzegithubusers.service.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Component
public class UserInitializer {
    private final IUserService userService;

    @PostConstruct
    void init() {
        userService.saveUsers();
    }
}
