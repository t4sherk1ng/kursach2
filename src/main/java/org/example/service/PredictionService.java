package org.example.service;

import ai.catboost.CatBoostModel;
import ai.catboost.CatBoostPredictions;
import jakarta.annotation.PostConstruct;
import org.example.dto.PredictionRequestDto;
import org.example.dto.PredictionResponseDto;
import org.springframework.stereotype.Service;

import java.io.InputStream;

public interface PredictionService {
    PredictionResponseDto predict(PredictionRequestDto requestDto);
}

