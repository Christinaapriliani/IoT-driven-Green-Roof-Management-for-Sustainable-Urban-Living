package com.christina.analytics.controller;

import com.christina.analytics.model.AnalysisResult;
import com.christina.analytics.service.AnalyticsService;
import com.christina.sensor.model.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @Autowired
    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @PostMapping("/analyze")
    public AnalysisResult analyzeSensorData(@RequestBody SensorData sensorData) {
        return analyticsService.analyzeSensorData(sensorData);
    }
}
