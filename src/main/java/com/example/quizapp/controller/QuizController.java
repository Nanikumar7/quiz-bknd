package com.example.quizapp.controller;


import com.example.quizapp.entity.Admin;
import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.Score;
import com.example.quizapp.entity.User;
import com.example.quizapp.service.AdminService;
import com.example.quizapp.service.QuestionService;
import com.example.quizapp.service.ScoreService;
import com.example.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3003/")
@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ScoreService scoreService;

    // User Registration
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered with unique ID: " + user.getUniqueUserId());
    }

    // User Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String uniqueUserId, @RequestParam String password) {
        User user = userService.findByUniqueUserId(uniqueUserId);
        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    // Admin Login
    @PostMapping("/admin/login")
    public ResponseEntity<String> adminLogin(@RequestParam String username, @RequestParam String password) {
        Admin admin = adminService.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return ResponseEntity.ok("Admin login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid admin credentials");
        }
    }

//    // Add Question
//    @PostMapping("/admin/addQuestion")
//    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
//        questionService.save(question);
//        return ResponseEntity.ok("Question added successfully!");
//    }
    
    
    
    
    
    @PostMapping("/admin/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        try {
            questionService.save(question);  // Save question to the database
            return ResponseEntity.ok("Question added successfully!");  // Success message
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving question: " + e.getMessage());
        }
    }

    // Delete Question
    @DeleteMapping("/admin/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok("Question deleted successfully!");
    }

    // Get All Questions
    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // Save User Score
    @PostMapping("/user/saveScore")
    public ResponseEntity<String> saveScore(@RequestBody Score score) {
        scoreService.saveScore(score);
        return ResponseEntity.ok("Score saved successfully!");
    }

    // Get User Scores
    @GetMapping("/user/scores/{userId}")
    public List<Score> getUserScores(@PathVariable Long userId) {
        return scoreService.getUserScores(userId);
    }
}

