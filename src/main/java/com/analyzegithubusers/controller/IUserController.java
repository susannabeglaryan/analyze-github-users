package com.analyzegithubusers.controller;

import com.analyzegithubusers.model.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface IUserController {

    @GetMapping("/all")
    ResponseEntity<Page<UserResponseDTO>> getPagedUsers(
            @RequestParam(required = false) String login,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) String location,
            @PageableDefault(sort = "profileCreatedAt", direction = Sort.Direction.ASC) Pageable pageable
    );

    @GetMapping("/all/groupedByCompany")
    ResponseEntity<Map<String, List<UserResponseDTO>>> getUsersGroupedByCompany();

    @GetMapping("/all/groupedByLocation")
    ResponseEntity<Map<String, List<UserResponseDTO>>> getUsersGroupedByLocation();

}
