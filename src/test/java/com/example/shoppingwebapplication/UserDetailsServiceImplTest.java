package com.example.shoppingwebapplication;

import com.example.shoppingwebapplication.Entity.User;
import com.example.shoppingwebapplication.Services.UserDetailsServiceImpl;
import com.example.shoppingwebapplication.Services.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserDetailsServiceImplTest {
    private UserServiceImpl userService = mock(UserServiceImpl.class);
    private UserDetailsServiceImpl userDetailsService;

    @Before
    public void setUp() {
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");
        user.setAddress("address");
        user.setEmail("email");
        user.setRole("USER");

        userDetailsService = new UserDetailsServiceImpl(userService);
        when(userService.findByUserName(Mockito.anyString())).thenReturn(user);
    }

    @Test
    public void whenloadUserByUsername_thenReturnUserDetails() {
        assertNotNull(userDetailsService.loadUserByUsername("user1"));
        assertNotNull(userDetailsService.loadUserByUsername("user1").getPassword());
        assertEquals(userDetailsService.loadUserByUsername("user1").getPassword(), "password");
        assertEquals(userDetailsService.loadUserByUsername("user1").isAccountNonExpired(), true);
        assertEquals(userDetailsService.loadUserByUsername("user1").isAccountNonLocked(), true);
        assertEquals(userDetailsService.loadUserByUsername("user1").isEnabled(), true);
        assertEquals(userDetailsService.loadUserByUsername("user1").isCredentialsNonExpired(), true);

    }
}
