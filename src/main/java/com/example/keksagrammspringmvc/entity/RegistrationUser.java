package com.example.keksagrammspringmvc.entity;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationUser {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String eMail;

    public User convertToUser() {
        return new User(
                username,
                password,
                firstName,
                lastName,
                eMail
        );
    }

}
