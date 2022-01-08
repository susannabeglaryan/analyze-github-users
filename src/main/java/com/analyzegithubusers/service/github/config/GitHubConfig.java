package com.analyzegithubusers.service.github.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

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
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().basicAuthentication(username, token).rootUri(baseUrl).build();
    }
}
