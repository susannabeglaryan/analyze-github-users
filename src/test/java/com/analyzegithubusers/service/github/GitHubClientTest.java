package com.analyzegithubusers.service.github;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GitHubClientTest {
    @Autowired
    private GitHubClient gitHubClient;

    @Test
    void getAllUsers() {
        gitHubClient.getAllUsers("10", "");
    }

    @Test
    void getUser() {
        gitHubClient.getUser("susannabeglaryan");
    }
}