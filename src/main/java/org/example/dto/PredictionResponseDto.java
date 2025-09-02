package org.example.dto;


public class PredictionResponseDto {

    private double predictedValue;

    public PredictionResponseDto(double predictedValue) {
        this.predictedValue = predictedValue;
    }

    public PredictionResponseDto() {}

    // Геттеры и сеттеры
    public double getPredictedValue() {
        return predictedValue;
    }

    public void setPredictedValue(double predictedValue) {
        this.predictedValue = predictedValue;
    }
}
