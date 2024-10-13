package com.example.quizapp.service;



import com.example.quizapp.entity.User;

public interface UserService {
    User findByUsername(String username);
    User findByUniqueUserId(String uniqueUserId);
    void registerUser(User user);
}

