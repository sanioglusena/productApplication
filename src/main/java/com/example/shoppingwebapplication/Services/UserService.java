package com.example.shoppingwebapplication.Services;

import com.example.shoppingwebapplication.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void saveUser(User user);

    User findByUserName(String userName);
}
