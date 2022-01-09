package com.analyzegithubusers.service.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class GithubUserResponse {
    @JsonProperty("login")
    private String login;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("url")
    private String url;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("followers_url")
    private String followersUrl;

    @JsonProperty("following_url")
    private String followingUrl;

}
