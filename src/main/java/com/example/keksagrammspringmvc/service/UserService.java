package com.example.keksagrammspringmvc.service;

import com.example.keksagrammspringmvc.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<User> findUserById(Long id);

    List<User> getAllUser();

    boolean saveUser(User user);

    boolean deleteUser(Long id);
}
