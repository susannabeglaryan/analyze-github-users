package com.analyzegithubusers.service.user;

import com.analyzegithubusers.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserSavingFilter implements UserFilter {

    Integer publicReposMoreThan;
    Integer followersMoreThan;
    LocalDateTime profileCreatedAfter;

    @Override
    public boolean isMatching(User user) {
        return isPublicReposMatching(user) &&
                isFollowersMatching(user) &&
                isProfileAgeMatching(user);
    }

    private boolean isPublicReposMatching(User user) {
       return publicReposMoreThan == null || user.getUserDetails().getPublicRepos() > publicReposMoreThan;
    }

    private boolean isFollowersMatching(User user) {
       return followersMoreThan == null || user.getUserDetails().getFollowers() > followersMoreThan;
    }

    private boolean isProfileAgeMatching(User user) {
        return profileCreatedAfter == null || user.getUserDetails().getCreatedAt().isAfter(profileCreatedAfter);
    }
}
