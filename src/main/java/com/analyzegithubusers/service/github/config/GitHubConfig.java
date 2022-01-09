package com.analyzegithubusers.service.github.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Getter
public class GitHubConfig {
    @Value("${github.username}")
    private String username;

    @Value("${github.token}")
    private String token;

    @Value("${github.baseUrl}")
    private String baseUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(baseUrl).defaultHeaders(header -> {
            header.setBasicAuth(username, token);
        }).build();
    }
}
