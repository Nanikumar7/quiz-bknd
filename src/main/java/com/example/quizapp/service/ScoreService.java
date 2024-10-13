package com.example.quizapp.service;


import com.example.quizapp.entity.Score;

import java.util.List;

public interface ScoreService {
    void saveScore(Score score);
    List<Score> getUserScores(Long userId);
}
