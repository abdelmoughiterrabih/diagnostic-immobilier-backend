package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.usermodel.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService extends UserDetails {
    List<User> getAllUser();
    User findUserProfileByJwt(String jwt);
    User getUserByEmail(String email);
    void createUser(User user);
    List<User> getAllUsers();
    User findUserById(String userId);
    List<User> findAllUsers();

    UserDetails loadUserByUsername(String username);
}