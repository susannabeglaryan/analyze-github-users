package com.analyzegithubusers.persistence.repository;

import com.analyzegithubusers.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends PagingAndSortingRepository<UserEntity, Long>,
        JpaSpecificationExecutor<UserEntity> {
}
