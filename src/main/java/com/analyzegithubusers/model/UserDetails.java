package com.analyzegithubusers.model;

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
public class UserDetails {
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
