package com.kareem.spring_security_demo.service;

import com.kareem.spring_security_demo.model.User;
import com.kareem.spring_security_demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public User saveUser(User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

}
