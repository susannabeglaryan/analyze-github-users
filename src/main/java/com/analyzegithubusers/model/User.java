package com.analyzegithubusers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String login;

    private Long id;

    private String avatarUrl;

    private String url;

    private String htmlUrl;

    private String followersUrl;

    private String followingUrl;

    private UserDetails userDetails;

}
