package com.example.keksagrammspringmvc.repository;

import com.example.keksagrammspringmvc.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
