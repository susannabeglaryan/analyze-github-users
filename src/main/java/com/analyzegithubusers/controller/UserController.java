package com.analyzegithubusers.controller;

import com.analyzegithubusers.model.UserResponseDTO;
import com.analyzegithubusers.model.mapper.UserMapper;
import com.analyzegithubusers.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.analyzegithubusers.model.mapper.UserMapper.toUserResponseDTOMap;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController implements IUserController {

    private final UserService userService;

    public ResponseEntity<Page<UserResponseDTO>> getPagedUsers(
            String login,
            String company,
            String location,
            Pageable pageable
    ) {
        Page<UserResponseDTO> response = userService.getPagedUsers(login, company, location, pageable)
                .map(UserMapper::toUserResponseDTO);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Map<String, List<UserResponseDTO>>> getUsersGroupedByCompany() {
        var response = toUserResponseDTOMap(userService.getUsersGroupedByCompany());
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Map<String, List<UserResponseDTO>>> getUsersGroupedByLocation() {
        var response = toUserResponseDTOMap(userService.getUsersGroupedByLocation());
        return ResponseEntity.ok(response);
    }
}
