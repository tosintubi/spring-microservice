package org.tommot.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tommot.userservice.model.User;
import org.tommot.userservice.service.UserService;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private UserService userService;

    @PostMapping("/new/")
    public ResponseEntity<User> saveUser(User user){
        log.info("Implementing: saveUser");
        User newUser = userService.saveUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
}
