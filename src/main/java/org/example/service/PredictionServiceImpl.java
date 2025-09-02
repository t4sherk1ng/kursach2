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
        } catch (IOException | CatBoostError e) {
            throw new RuntimeException("Could not load CatBoost model from " + modelPath, e);
        }
    }

    private float convertTimeToMinutes(String time) {
        if (time == null || time.isEmpty()) return 0f;
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    @Override
    public PredictionResponseDto predict(PredictionRequestDto requestDto) {
        String[] catFeatures = new String[] {
                requestDto.getDelivery_person_id(),
                requestDto.getWeather_conditions(),
                requestDto.getRoad_traffic_density(),
                requestDto.getType_of_order(),
                requestDto.getType_of_vehicle(),
                requestDto.getFestival(),
                requestDto.getCity()
        };

        float[] numFeatures = new float[] {
                (float) requestDto.getDelivery_person_age(),
                (float) requestDto.getDelivery_person_ratings(),
                (float) requestDto.getRestaurant_latitude(),
                (float) requestDto.getRestaurant_longitude(),
                (float) requestDto.getDelivery_location_latitude(),
                (float) requestDto.getDelivery_location_longitude(),
                (float) requestDto.getVehicle_condition(),
                (float) requestDto.getMultiple_deliveries(),
                (float) requestDto.getDistance_km(),
                (float) requestDto.getOrder_price(),
                convertTimeToMinutes(requestDto.getTime_ordered()),
                convertTimeToMinutes(requestDto.getTime_order_picked())
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
