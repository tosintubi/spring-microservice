package org.tommot.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommot.userservice.model.User;
import org.tommot.userservice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
