package com.analyzegithubusers.controller.mapper;

import com.analyzegithubusers.controller.dto.UserGroupResponseDTO;
import com.analyzegithubusers.model.User;

import java.util.List;

public class UserGroupViewMapper {
    static public UserGroupResponseDTO toUserGroupResponseDTO(String key, List<User> users) {
        return new UserGroupResponseDTO(key, UserViewMapper.toUserResponseDTOList(users));
    }
}
