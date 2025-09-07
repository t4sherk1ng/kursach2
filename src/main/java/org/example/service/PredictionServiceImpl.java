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

    @Override
    public PredictionResponseDto predict(PredictionRequestDto requestDto) {
        // все 19 признаков CatBoost
        String[] catFeatures = new String[] {
                requestDto.getID() != null ? requestDto.getID() : "",
                requestDto.getDelivery_person_ID() != null ? requestDto.getDelivery_person_ID() : "",
                requestDto.getDelivery_person_Age() != null ? requestDto.getDelivery_person_Age() : "",
                requestDto.getDelivery_person_Ratings() != null ? requestDto.getDelivery_person_Ratings() : "",
                requestDto.getRestaurant_latitude() != null ? requestDto.getRestaurant_latitude() : "",
                requestDto.getRestaurant_longitude() != null ? requestDto.getRestaurant_longitude() : "",
                requestDto.getDelivery_location_latitude() != null ? requestDto.getDelivery_location_latitude() : "",
                requestDto.getDelivery_location_longitude() != null ? requestDto.getDelivery_location_longitude() : "",
                requestDto.getOrder_Date() != null ? requestDto.getOrder_Date() : "",
                requestDto.getTime_Orderd() != null ? requestDto.getTime_Orderd() : "",
                requestDto.getTime_Order_picked() != null ? requestDto.getTime_Order_picked() : "",
                requestDto.getWeatherconditions() != null ? requestDto.getWeatherconditions() : "",
                requestDto.getRoad_traffic_density() != null ? requestDto.getRoad_traffic_density() : "",
                requestDto.getVehicle_condition() != null ? requestDto.getVehicle_condition() : "",
                requestDto.getType_of_order() != null ? requestDto.getType_of_order() : "",
                requestDto.getType_of_vehicle() != null ? requestDto.getType_of_vehicle() : "",
                requestDto.getMultiple_deliveries() != null ? requestDto.getMultiple_deliveries() : "",
                requestDto.getFestival() != null ? requestDto.getFestival() : "",
                requestDto.getCity() != null ? requestDto.getCity() : ""
        };

        try {
            CatBoostPredictions prediction = model.predict(new float[1], catFeatures);
            double predictedValue = prediction.get(0, 0);
            logger.info("Model returned prediction: {}", predictedValue);
            return new PredictionResponseDto(predictedValue);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get prediction", e);
        }
    }
}
