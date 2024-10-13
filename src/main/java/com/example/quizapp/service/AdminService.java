package com.example.quizapp.service;


import com.example.quizapp.entity.Admin;

public interface AdminService {
    Admin findByUsername(String username);
    void addAdmin(Admin admin);
}
