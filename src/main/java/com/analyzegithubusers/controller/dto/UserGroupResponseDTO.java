package com.analyzegithubusers.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserGroupResponseDTO {

    String groupKey;

    List<UserResponseDTO> users;
}
