package com.example.keksagrammspringmvc.service;

import com.example.keksagrammspringmvc.entity.Role;
import com.example.keksagrammspringmvc.entity.User;
import com.example.keksagrammspringmvc.repository.RoleRepository;
import com.example.keksagrammspringmvc.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public boolean saveUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        } else {
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
//            user.setPassword();
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        if (!userRepository.findById(id).isPresent()) {
            return false;
        } else {
            userRepository.deleteById(id);
            return true;
        }
    }
}
