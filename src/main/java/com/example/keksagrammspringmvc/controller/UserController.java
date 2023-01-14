package com.example.keksagrammspringmvc.controller;

import com.example.keksagrammspringmvc.entity.User;
import com.example.keksagrammspringmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("users", repository.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", repository.findById(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new-user";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", repository.findById(id).get());
        return "edit-user";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(
            @PathVariable("id") Long id,
            User user,
            BindingResult result,
            Model model) {
        repository.save(user);
        return "redirect:/";
    }

    @PostMapping("/new")
    public String saveUser(@ModelAttribute("user") User user) {
        repository.save(user);
        return "redirect:/";
    }
}
