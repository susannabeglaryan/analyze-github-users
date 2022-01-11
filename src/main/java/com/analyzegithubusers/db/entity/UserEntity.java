package com.analyzegithubusers.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "UserEntity")
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "source_id")
    private Long sourceId;

    @Column(name = "login")
    private String login;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "url")
    private String url;

    @Column(name = "html_url")
    private String htmlUrl;

    @Column(name = "followers_url")
    private String followersUrl;

    @Column(name = "following_url")
    private String followingUrl;

    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;

    @Column(name = "location")
    private String location;

    @Column(name = "email")
    private String email;

    @Column(name = "public_repos")
    private Integer publicRepos;

    @Column(name = "followers")
    private Integer followers;

    @Column(name = "following")
    private Integer following;

    @Column(name = "profile_created_at")
    private LocalDateTime profileCreatedAt;

    @Column(name = "total_private_repos")
    private Integer totalPrivateRepos;

    @Column(name = "owned_private_repos")
    private Integer ownedPrivateRepos;
}
