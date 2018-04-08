package com.example.shoppingwebapplication.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User entity class
 * In this demo project the only defined role is USER
 */

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String email;

    private String address;

    @NotNull
    @Size(min = 6)
    private String password;

    private String role;

    public User(String username, String email, String address, String password, String role) {
        this.username = username;
        this.email = email;
        this.address = address;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
