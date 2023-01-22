package com.example.keksagrammspringmvc.controller;

import com.example.keksagrammspringmvc.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    private PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/home")
    public String showPosts(Model model) {
        model.addAttribute("posts", repository.findAll());
        return "home";
    }
}
