package org.tommot.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tommot.userservice.VO.ResponseTemplateVO;
import org.tommot.userservice.model.User;
import org.tommot.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class  UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new/")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        log.info("Implementing: saveUser");
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping({"/all","/"})
    public ResponseEntity<List<User>> getAllUsers(){
        log.info("Implementing: getAllDepartments");
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);}


    // Fetch user with their departments
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Implementing: getUserWithDepartment");
        return userService.getUserWithDepartment(userId);
    }
}
