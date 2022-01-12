package com.analyzegithubusers.controller;


import com.analyzegithubusers.controller.dto.UserGroupResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

public interface IUserGroupController {

    @GetMapping(path = "/byCompany", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ApiResponse(content = @Content(mediaType = "text/event-stream"),
            description = "Returns grouped list of users or empty list if there is no user")
    @Operation(summary = "Get grouped users by company",
            description = "Use this API to retrieve user list grouped by company.")
    Flux<UserGroupResponseDTO> getUsersGroupedByCompany();

    @GetMapping(path = "/byLocation", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ApiResponse(content = @Content(mediaType = "text/event-stream"),
            description = "Returns grouped list of users or empty list if there is no user")
    @Operation(summary = "Get grouped users by location",
            description = "Use this API to retrieve user list grouped by location.")
    Flux<UserGroupResponseDTO> getUsersGroupedByLocation();
    
}
