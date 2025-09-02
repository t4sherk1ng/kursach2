package org.example.service;

import ai.catboost.CatBoostError;
import ai.catboost.CatBoostModel;
import ai.catboost.CatBoostPredictions;
import jakarta.annotation.PostConstruct;
import org.example.dto.PredictionRequestDto;
import org.example.dto.PredictionResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PredictionServiceImpl implements PredictionService {

    private static final Logger logger = LoggerFactory.getLogger(PredictionServiceImpl.class);
    private CatBoostModel model;
    private final String modelPath = "/food_catboost.cbm";

    @PostConstruct
    public void init() {
        try {
            model = CatBoostModel.loadModel(getClass().getResourceAsStream(modelPath));
        } catch (IOException e) {
            throw new RuntimeException("Could not load CatBoost model from " + modelPath, e);
        } catch (CatBoostError e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PredictionResponseDto predict(PredictionRequestDto requestDto) {
        String[] catFeatures = new String[] {
                requestDto.getCity(),
                requestDto.getRoad_traffic_density(),
                requestDto.getWeather_conditions()
        };

        float[] numFeatures = new float[] {
                (float) requestDto.getDistance_km(),
                (float) requestDto.getDelivery_person_rating(),
                (float) requestDto.getMultiple_orders(),
                (float) requestDto.getOrder_price(),
                (float) requestDto.getVehicle_age(),
                (float) requestDto.getVehicle_rating()
        };

        try {
            CatBoostPredictions prediction = model.predict(numFeatures, catFeatures);
            double predictedValue = prediction.get(0, 0);
            logger.info("Model returned prediction: {}", predictedValue);
            return new PredictionResponseDto(predictedValue);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get prediction", e);
        }
    }
}