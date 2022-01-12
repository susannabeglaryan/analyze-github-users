package com.analyzegithubusers.service.user;

import com.analyzegithubusers.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserSavingFilterTest {

    private static User firstUser;
    private static User secondUser;

    @BeforeAll
    static void init() {
        firstUser = User.builder()
                .login("susannabeglaryan")
                .id(156L)
                .name("Susanna")
                .company("My company")
                .location("Yerevan")
                .email("susanna.beglaryan@gmail.com")
                .publicRepos(15)
                .followers(22)
                .createdAt(LocalDateTime.of(2018, Month.APRIL, 1, 12, 30))
                .build();

        secondUser = User.builder()
                .login("johndoe")
                .id(256L)
                .name("John")
                .company("My company")
                .location("Yerevan")
                .email("john@gmail.com")
                .publicRepos(3)
                .followers(15)
                .createdAt(LocalDateTime.of(2015, Month.APRIL, 1, 12, 30))
                .build();
    }

    @Test
    void isMatching_emptyFilter() {
        UserSavingFilter filter = new UserSavingFilter();

        assertTrue(filter.isMatching(firstUser));
        assertTrue(filter.isMatching(secondUser));
    }

    @Test
    void isMatching() {
        UserSavingFilter filter = new UserSavingFilter();
        filter.setProfileCreatedAfter(LocalDateTime.of(2016, Month.APRIL, 1, 12, 30));
        filter.setFollowersMoreThan(20);

        assertTrue(filter.isMatching(firstUser));
        assertFalse(filter.isMatching(secondUser));

        filter.setPublicReposMoreThan(10);
        assertTrue(filter.isMatching(firstUser));

        filter.setPublicReposMoreThan(30);
        assertFalse(filter.isMatching(firstUser));
    }

}