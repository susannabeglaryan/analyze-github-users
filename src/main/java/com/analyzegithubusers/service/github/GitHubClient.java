package com.analyzegithubusers.service.github;

import com.analyzegithubusers.service.github.exception.GitHubException;
import com.analyzegithubusers.service.github.model.GithubUserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class GitHubClient {
    private static final String GET_USER_URL = "/user";
    private static final String GET_USERS_URL = "/users";
    private static final String SINCE_PARAM = "since";
    private static final String USERNAME_PARAM = "username";
    private static final String PER_PAGE_PARAM = "per_page";

    private final RestTemplate restTemplate;

    public List<GithubUserResponse> getAllUsers(String perPage, String since) {
        try {
            var url = UriComponentsBuilder.fromUriString(GET_USERS_URL)
                    .queryParam(PER_PAGE_PARAM, perPage)
                    .queryParam(SINCE_PARAM, since)
                    .build().toString();
            ResponseEntity<GithubUserResponse[]> result = restTemplate.getForEntity(url, GithubUserResponse[].class);
            return result.getBody() != null ? List.of(result.getBody()) : Collections.emptyList();
        } catch (RestClientException ex) {
            log.error(ex.getMessage());
            throw new GitHubException(ex.getMessage());
        }
    }

    public GithubUserResponse getUser(String username) {
        try {
            var url = UriComponentsBuilder.fromUriString(GET_USER_URL)
                    .queryParam(USERNAME_PARAM, username)
                    .build().toString();
            ResponseEntity<GithubUserResponse> result = restTemplate.getForEntity(url, GithubUserResponse.class);
            return result.getBody();
        } catch (RestClientException ex) {
            log.error(ex.getMessage());
            throw new GitHubException(ex.getMessage());
        }
    }
}
