package com.github.evan.springboot.auto.application.controller;

import com.github.evan.springboot.auto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private User user;

    @GetMapping("user/v1")
    public User getUser() {
        return user;
    }
}
