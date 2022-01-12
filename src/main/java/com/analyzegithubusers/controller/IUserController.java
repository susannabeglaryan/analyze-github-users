package com.analyzegithubusers.controller;

import com.analyzegithubusers.controller.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

public interface IUserController {

    @GetMapping("/all")
    @ApiResponse(content = @Content(mediaType = "application/json"),
            description = "Returns page of users or empty list if there is no user")
    @Operation(summary = "Get paginated users",
            description = "Use this API to retrieve paged list of users.")
    Flux<UserResponseDTO> getPagedUsers(
            @Parameter(description = "Use for filtering users by login, filters users whose login partially matche provided string", example = "jdp")
            @RequestParam(required = false)
                    String login,

            @Parameter(description = "Use for filtering users by company, works with exact match", example = "Streamable")
            @RequestParam(required = false)
                    String company,

            @Parameter(description = "Use for filtering users by location, works with exact match", example = "NYC")
            @RequestParam(required = false)
                    String location,

            @Parameter(description = "Use to get partial data by providing pagination details")
            @PageableDefault(sort = "profileCreatedAt", direction = Sort.Direction.ASC)
                    Pageable pageable
    );


}
