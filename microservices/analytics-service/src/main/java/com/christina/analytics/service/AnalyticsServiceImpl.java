package com.example.analytics.service;

import com.example.analytics.model.AnalysisResult;
import com.example.sensor.model.SensorData;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    @Override
    public AnalysisResult analyzeSensorData(SensorData sensorData) {
        boolean temperatureOptimal = isTemperatureOptimal(sensorData.getTemperature());
        boolean humidityOptimal = isHumidityOptimal(sensorData.getHumidity());

        String temperatureAnalysis = temperatureOptimal ? "Temperature is optimal" : "Temperature is not optimal";
        String humidityAnalysis = humidityOptimal ? "Humidity is optimal" : "Humidity is not optimal";

        String overallAnalysis = (temperatureOptimal && humidityOptimal) ? "Optimal" : "Suboptimal";

        return new AnalysisResult(overallAnalysis, temperatureAnalysis, humidityAnalysis);
    }

    private boolean isTemperatureOptimal(double temperature) {
        return temperature >= 20 && temperature <= 30;
    }

    private boolean isHumidityOptimal(double humidity) {
        return humidity >= 40 && humidity <= 60;
    }
}
