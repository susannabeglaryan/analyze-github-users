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
    private String id;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("url")
    private String url;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("name")
    private String name;

    @JsonProperty("followers_url")
    private String followersUrl;

    @JsonProperty("following_url")
    private String followingUrl;

    @JsonProperty("company")
    private String company;

    @JsonProperty("location")
    private String location;

    @JsonProperty("email")
    private String email;

    @JsonProperty("public_repos")
    private Integer publicRepos;

    @JsonProperty("followers")
    private Integer followers;

    @JsonProperty("following")
    private Integer following;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("total_private_repos")
    private Integer totalPrivateRepos;

    @JsonProperty("owned_private_repos")
    private Integer ownedPrivateRepos;

}
