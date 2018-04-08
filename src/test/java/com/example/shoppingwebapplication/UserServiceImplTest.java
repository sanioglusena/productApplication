package com.example.shoppingwebapplication;

import com.example.shoppingwebapplication.Entity.User;
import com.example.shoppingwebapplication.Repository.UserRepository;
import com.example.shoppingwebapplication.Services.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    private UserRepository userRepository = mock(UserRepository.class);
    private UserServiceImpl userService;

    @Before
    public void setUp() {
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        user.setAddress("address");
        user.setEmail("email");

        userService = new UserServiceImpl(userRepository);

        when(userRepository.findByusername(Mockito.anyString())).thenReturn(user);
        when(userRepository.save(Mockito.any())).thenReturn("OK");
    }

    @Test
    public void whenfindByUserName_thenReturnUser() {
        assertNotNull(userService.findByUserName("user1"));
        assertEquals(userService.findByUserName("user1").getPassword(), "password");
        assertEquals(userService.findByUserName("user1").getEmail(), "email");
        assertEquals(userService.findByUserName("user1").getAddress(), "address");
    }
}
