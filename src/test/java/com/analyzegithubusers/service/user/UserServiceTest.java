package com.analyzegithubusers.service.user;

import com.analyzegithubusers.service.user.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getAllUsers() {
        userService.saveUsers();
    }
}