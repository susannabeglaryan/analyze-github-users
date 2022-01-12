package com.analyzegithubusers.service.user.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    @Order(1)
    void saveUsers() {
        userService.saveUsers();
    }

    @Test
    @Order(2)
    void getPagedUsers() {
        Pageable pageable = Pageable.ofSize(5);
        userService.getPagedUsers(null, null, null, pageable)
                .count().subscribe((c) -> {
                    assertEquals(c, 5);
                });

    }
}