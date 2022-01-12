package com.analyzegithubusers.controller.mapper;

import com.analyzegithubusers.controller.dto.UserResponseDTO;
import com.analyzegithubusers.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserViewMapper {

    public static UserResponseDTO toUserResponseDTO(User user) {
        return UserResponseDTO.builder()
                .login(user.getLogin())
                .id(user.getId())
                .avatarUrl(user.getAvatarUrl())
                .url(user.getUrl())
                .htmlUrl(user.getHtmlUrl())
                .followersUrl(user.getFollowersUrl())
                .followingUrl(user.getFollowingUrl())
                .name(user.getName())
                .company(user.getCompany())
                .location(user.getLocation())
                .email(user.getEmail())
                .publicRepos(user.getPublicRepos())
                .followers(user.getFollowers())
                .following(user.getFollowing())
                .createdAt(user.getCreatedAt())
                .totalPrivateRepos(user.getTotalPrivateRepos())
                .ownedPrivateRepos(user.getOwnedPrivateRepos())
                .build();
    }

    public static List<UserResponseDTO> toUserResponseDTOList(List<User> users) {
        return users.stream()
                .map(UserViewMapper::toUserResponseDTO)
                .collect(Collectors.toList());
    }
}
