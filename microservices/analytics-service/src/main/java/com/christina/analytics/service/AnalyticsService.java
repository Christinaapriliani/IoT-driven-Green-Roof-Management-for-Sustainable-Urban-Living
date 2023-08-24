package com.example.analytics.service;

import com.example.analytics.model.AnalysisResult;
import com.example.sensor.model.SensorData;

public interface AnalyticsService {
    AnalysisResult analyzeSensorData(SensorData sensorData);
}
