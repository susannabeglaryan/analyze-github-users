package com.analyzegithubusers.service.github;

import com.analyzegithubusers.service.github.exception.GitHubException;
import com.analyzegithubusers.service.github.model.GithubUserDetailsResponse;
import com.analyzegithubusers.service.github.model.GithubUserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    private final WebClient webClient;

    public Flux<GithubUserResponse> getAllUsers(String perPage, String since) {
            var url = UriComponentsBuilder.fromUriString(GET_USERS_URL)
                    .queryParam(PER_PAGE_PARAM, perPage)
                    .queryParam(SINCE_PARAM, since)
                    .build().toString();
            Flux<GithubUserResponse> result = webClient
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToFlux(GithubUserResponse.class);
            return result;
    }

    public Mono<GithubUserDetailsResponse> getUser(String username) {
        var url = UriComponentsBuilder.fromUriString(GET_USER_URL)
                .queryParam(USERNAME_PARAM, username)
                .build().toString();
        Mono<GithubUserDetailsResponse> result = webClient.get()
                .uri(url).retrieve()
                .bodyToMono(GithubUserDetailsResponse.class);
        return result;
    }
}
