package com.example.shoppingwebapplication.Repository;

import com.example.shoppingwebapplication.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    User findById(int Id);

    User findByusername(String username);
}
