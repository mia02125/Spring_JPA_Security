package com.security.demo.service;

import com.security.demo.entity.User;
import com.security.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> selectUser(User user) {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public User insert(User user) {
        BCryptPasswordEncoder PWencoder = new BCryptPasswordEncoder();
        user.setUserPassword(PWencoder.encode(user.getUserPassword()));
        return userRepository.save(user);
    }

}
