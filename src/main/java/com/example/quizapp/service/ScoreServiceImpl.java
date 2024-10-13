package com.example.quizapp.service;



import com.example.quizapp.entity.Score;
import com.example.quizapp.repository.ScoreRepository;
import com.example.quizapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveScore(Score score) {
        scoreRepository.save(score);
    }

    @Override
    public List<Score> getUserScores(Long userId) {
        return scoreRepository.findAllByUser_Id(userId);
    }
}
