package com.analyzegithubusers.service.github.mapper;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.model.UserDetails;
import com.analyzegithubusers.service.github.model.GithubUserDetailsResponse;
import com.analyzegithubusers.service.github.model.GithubUserResponse;

import java.time.LocalDateTime;

public class GithubUserMapper {

    public static User setUserDetails(User user, GithubUserDetailsResponse userResponse) {
        LocalDateTime createdAt = LocalDateTime.parse(userResponse.getCreatedAt().replace("Z", ""));

        user.setName(userResponse.getName());
        user.setCompany(userResponse.getCompany());
        user.setLocation(userResponse.getLocation());
        user.setEmail(userResponse.getEmail());
        user.setPublicRepos(userResponse.getPublicRepos());
        user.setFollowers(userResponse.getFollowers());
        user.setFollowing(userResponse.getFollowing());
        user.setCreatedAt(createdAt);
        user.setTotalPrivateRepos(userResponse.getTotalPrivateRepos());
        user.setOwnedPrivateRepos(userResponse.getOwnedPrivateRepos());

        return user;
    }

    public static User toUser(GithubUserResponse userResponse) {
        return User.builder()
                .login(userResponse.getLogin())
                .id(userResponse.getId())
                .avatarUrl(userResponse.getAvatarUrl())
                .url(userResponse.getUrl())
                .htmlUrl(userResponse.getHtmlUrl())
                .followersUrl(userResponse.getFollowersUrl())
                .followingUrl(userResponse.getFollowingUrl())
                .build();
    }
}
