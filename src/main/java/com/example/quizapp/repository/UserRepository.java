package com.example.quizapp.repository;


import com.example.quizapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUniqueUserId(String uniqueUserId);
}
