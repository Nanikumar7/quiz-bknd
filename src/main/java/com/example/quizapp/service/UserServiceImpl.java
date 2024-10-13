package com.example.quizapp.service;


import com.example.quizapp.entity.User;
import com.example.quizapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUniqueUserId(String uniqueUserId) {
        return userRepository.findByUniqueUserId(uniqueUserId);
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }
}

