package com.example.quizapp.service;


import com.example.quizapp.entity.Admin;
import com.example.quizapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}
