package com.analyzegithubusers.service.user.model;

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
public class UserDetails {
    private String name;

    private String company;

    private String location;

    private String email;

    private Integer publicRepos;

    private Integer followers;

    private Integer following;

    private String createdAt;

    private Integer totalPrivateRepos;

    private Integer ownedPrivateRepos;
}
