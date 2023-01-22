package com.example.keksagrammspringmvc.controller;

import com.example.keksagrammspringmvc.entity.RegistrationUser;
import com.example.keksagrammspringmvc.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserRepository repository;

    public RegistrationController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String registrationForm() {
        return "registration-form";
    }

    @PostMapping
    public String processRegistrationNewUser(RegistrationUser newUser) {
        repository.save(newUser.convertToUser());
        return "redirect:/login";
    }
}
