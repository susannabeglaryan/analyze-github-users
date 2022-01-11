package com.analyzegithubusers.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private String login;

    private Long id;

    private String avatarUrl;

    private String url;

    private String htmlUrl;

    private String followersUrl;

    private String followingUrl;

    private String name;

    private String company;

    private String location;

    private String email;

    private Integer publicRepos;

    private Integer followers;

    private Integer following;

    private LocalDateTime createdAt;

    private Integer totalPrivateRepos;

    private Integer ownedPrivateRepos;

}