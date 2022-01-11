package com.analyzegithubusers.service.user;

import com.analyzegithubusers.model.User;
import com.analyzegithubusers.persistence.UserDAO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
@AllArgsConstructor
public class UserService {
    UserProvider userProvider;
    UserDAO userDAO;

    public void saveUsers() {
        UserSavingFilter userFilter = new UserSavingFilter();
        userFilter.setPublicReposMoreThan(5);
        userFilter.setFollowersMoreThan(10);
        userFilter.setProfileCreatedAfter(LocalDateTime.of(2007, Month.APRIL, 1, 12, 30));

        userProvider.getAllUsers(userFilter).subscribe((user) -> {
            var savedUser = userDAO.save(user);
            System.out.println(savedUser.getId() + ": " + savedUser.getUserDetails().getName());
        });
    }

    public Page<User> getPagedUsers(String login, String company, String location, Pageable pageable) {
        return userDAO.findAll(login, company, location, pageable);
    }

    public Map<String, List<User>> getUsersGroupedByCompany() {
        Map<String, List<User>> groupedUsers = new HashMap<>();
        List<User> allUsers = userDAO.findAll();
        allUsers.forEach(user -> {
            var key = user.getUserDetails().getCompany() == null ? "No company specified" : user.getUserDetails().getCompany();
            var item = groupedUsers.get(key);
            if (item != null) {
                item.add(user);
            } else {
                groupedUsers.put(key, new ArrayList<>(List.of(user)));
            }
        });
        return groupedUsers;
    }

    public Map<String, List<User>> getUsersGroupedByLocation() {
        Map<String, List<User>> groupedUsers = new HashMap<>();
        List<User> allUsers = userDAO.findAll();
        allUsers.forEach(user -> {
            var key = user.getUserDetails().getLocation() == null ? "No location specified" : user.getUserDetails().getLocation();
            var item = groupedUsers.get(key);
            if (item != null) {
                item.add(user);
            } else {
                groupedUsers.put(key, new ArrayList<>(List.of(user)));
            }
        });
        return groupedUsers;
    }
}
