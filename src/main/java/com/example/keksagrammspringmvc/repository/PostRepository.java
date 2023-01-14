package com.example.keksagrammspringmvc.repository;

import com.example.keksagrammspringmvc.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
