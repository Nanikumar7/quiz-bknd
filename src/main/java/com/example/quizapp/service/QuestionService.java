package com.example.quizapp.service;


import com.example.quizapp.entity.Question;

import java.util.List;

public interface QuestionService {
    void save(Question question);
    List<Question> getAllQuestions();
    void deleteQuestion(Long questionId);
}

