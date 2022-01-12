package com.analyzegithubusers.service.github;

import com.analyzegithubusers.service.github.exception.GitHubException;
import com.analyzegithubusers.service.github.model.GithubUserDetailsResponse;
import com.analyzegithubusers.service.github.model.GithubUserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
@Slf4j
public class GitHubClient {
    private static final String GET_USERS_URL = "/users";
    private static final String SINCE_PARAM = "since";
    private static final String PER_PAGE_PARAM = "per_page";

    private final WebClient webClient;

    public Flux<GithubUserResponse> getAllUsers(int perPage) {
        return getAllUsers(perPage, 0);
    }

    public Flux<GithubUserResponse> getAllUsers(int perPage, int since) {
        try{
            var url = UriComponentsBuilder.fromUriString(GET_USERS_URL)
                    .queryParam(PER_PAGE_PARAM, perPage)
                    .queryParam(SINCE_PARAM, since)
                    .build().toString();
            return webClient
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToFlux(GithubUserResponse.class);
        } catch (RuntimeException ex) {
            log.warn(ex.getMessage());
            throw new GitHubException(ex.getMessage());
        }
    }

    public Mono<GithubUserDetailsResponse> getUser(String username) {
        try {
            var url = UriComponentsBuilder.fromUriString(GET_USERS_URL + "/" +username)
                    .build().toString();
            return webClient.get()
                    .uri(url).retrieve()
                    .bodyToMono(GithubUserDetailsResponse.class);
        } catch (RuntimeException ex) {
            log.warn(ex.getMessage());
            throw new GitHubException(ex.getMessage());
        }
    }
}
