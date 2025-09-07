package org.example.controller;

import org.example.dto.PredictionRequestDto;
import org.example.dto.PredictionResponseDto;
import org.example.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PredictionController {

    private final PredictionService predictionService;

    @Autowired
    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @PostMapping("/predict")
    public PredictionResponseDto getPrediction(@RequestBody PredictionRequestDto requestDto) {
        return predictionService.predict(requestDto);
    }
}

