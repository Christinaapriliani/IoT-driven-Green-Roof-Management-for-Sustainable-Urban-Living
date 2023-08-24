package com.christina.sensor.kafka;

import com.christina.sensor.model.SensorData;
import com.example.analytics.service.AnalyticsService;
import com.example.analytics.model.AnalysisResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SensorDataConsumer {

    private final AnalyticsService analyticsService;

    @Autowired
    public SensorDataConsumer(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    private static final String TOPIC = "IoT-driven Green Roof";

    @KafkaListener(topics = TOPIC, groupId = "sensor-group")
    public void consumeSensorData(SensorData sensorData) {
        System.out.println("Received sensor data: " + sensorData);

        AnalysisResult analysisResult = analyticsService.analyzeSensorData(sensorData);

        System.out.println("Analysis result: " + analysisResult);
    }
}
