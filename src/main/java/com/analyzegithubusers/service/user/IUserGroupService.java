package com.analyzegithubusers.service.user;

import com.analyzegithubusers.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;

public interface IUserGroupService {

    Flux<GroupedFlux<String, User>> getUsersGroupedByCompany();

    Flux<GroupedFlux<String, User>> getUsersGroupedByLocation();
}
