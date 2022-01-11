package com.analyzegithubusers.controller;

import com.analyzegithubusers.model.mapper.UserMapper;
import com.analyzegithubusers.service.user.UserService;
import com.analyzegithubusers.model.UserResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.analyzegithubusers.model.mapper.UserMapper.toUserResponseDTOMap;

@RestController
@RequestMapping(path = "/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<Page<UserResponseDTO>> getPagedUsers(
            @RequestParam(required = false) String login,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) String location,
            @PageableDefault(sort = "profileCreatedAt", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<UserResponseDTO> response = userService.getPagedUsers(login, company, location, pageable)
                .map(UserMapper::toUserResponseDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all/groupedByCompany")
    public ResponseEntity<Map<String, List<UserResponseDTO>>> getUsersGroupedByCompany() {
        var response = toUserResponseDTOMap(userService.getUsersGroupedByCompany());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all/groupedByLocation")
    public ResponseEntity<Map<String, List<UserResponseDTO>>> getUsersGroupedByLocation() {
        var response = toUserResponseDTOMap(userService.getUsersGroupedByLocation());
        return ResponseEntity.ok(response);
    }

}
