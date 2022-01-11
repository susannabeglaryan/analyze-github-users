package com.analyzegithubusers.db.jpadao;

import com.analyzegithubusers.db.entity.UserEntity;
import com.analyzegithubusers.db.repository.UserRepository;
import com.analyzegithubusers.model.mapper.UserMapper;
import com.analyzegithubusers.persistence.UserDAO;
import com.analyzegithubusers.model.User;
import com.analyzegithubusers.service.filter.UserSpecBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import reactor.util.annotation.Nullable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.analyzegithubusers.model.mapper.UserMapper.toUser;
import static com.analyzegithubusers.model.mapper.UserMapper.toUserEntity;

@Component
@AllArgsConstructor
public class JPAUserDAO implements UserDAO {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        var userEntity = toUserEntity(user);
        var userOpt = userRepository.findBySourceId(user.getId());
        if (userOpt.isPresent()) {
            return toUser(userOpt.get());
        }
        var savedUserEntity = userRepository.save(userEntity);
        return toUser(savedUserEntity);
    }

    @Override
    public Page<User> findAll(String login, String company, String location, Pageable pageable) {
        Specification<UserEntity> spec = new UserSpecBuilder()
                .loginLike(login)
                .companyIs(company)
                .locationIs(location)
                .build();
        var all = userRepository.findAll(spec, pageable);
        return all.map(UserMapper::toUser);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserMapper::toUser);
    }

    @Override
    public List<User> findAll() {
        return StreamSupport.stream(
                        userRepository.findAll().spliterator(), false)
                .map(UserMapper::toUser)
                .collect(Collectors.toList());
    }

}
