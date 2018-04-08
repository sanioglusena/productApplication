package com.example.shoppingwebapplication;

import com.example.shoppingwebapplication.Entity.User;
import com.example.shoppingwebapplication.Repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenfindByusername_thenReturnUser() {
        // given
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        user.setAddress("address");
        user.setEmail("email");

        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByusername(user.getUsername());

        // then
        assertThat(found.getUsername())
                .isEqualTo(user.getUsername());
    }

    @Test
    public void whenfindByusername_thenDoNotReturnUser() {
        // given
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        user.setAddress("address");
        user.setEmail("email");

        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByusername(user.getUsername());

        // then
        assertNotEquals(found.getUsername(), "user2");
    }

    @Test
    public void whenfindById_thenReturnUser() {
        // given
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        user.setAddress("address");
        user.setEmail("email");

        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByusername(user.getUsername());
        User foundById = userRepository.findById(found.getId());
        // then
        assertThat(foundById.getId())
                .isEqualTo(user.getId());
    }

    @Test
    public void whenfindAll_thenReturnUserList() {
        // given
        // user 1
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        user.setAddress("address");
        user.setEmail("email");

        // user 2
        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("password");
        user2.setAddress("address");
        user2.setEmail("email");

        // user 3
        User user3 = new User();
        user3.setUsername("user3");
        user3.setPassword("password");
        user3.setAddress("address");
        user3.setEmail("email");

        entityManager.persist(user);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.flush();

        // when
        List<User> userList = userRepository.findAll();

        // then
        assertThat(userList.size())
                .isEqualTo(3);
    }
}
