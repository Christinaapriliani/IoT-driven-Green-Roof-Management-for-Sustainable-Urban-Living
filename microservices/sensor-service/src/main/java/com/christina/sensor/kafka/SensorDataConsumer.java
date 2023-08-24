package com.christina.sensor.kafka;

import com.christina.sensor.model.SensorData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SensorDataConsumer {

    private static final String TOPIC = "IoT-driven Green Roof";

    @KafkaListener(topics = TOPIC, groupId = "sensor-group")
    public void consumeSensorData(SensorData sensorData) {
        System.out.println("Received sensor data: " + sensorData);
        
        // Lakukan pengolahan data sensor sesuai kebutuhan
        double temperature = sensorData.getTemperature();
        double humidity = sensorData.getHumidity();
        
        if (temperature > 30) {
            System.out.println("Warning: Temperature is too high!");
        }
        
        if (humidity < 40) {
            System.out.println("Warning: Humidity is too low!");
        }
        
        if (temperature > 35 && humidity > 60) {
            System.out.println("Alert: Heat stress condition detected!");
        }
        
        if (temperature < 10) {
            System.out.println("Alert: Cold temperature detected!");
        }
        
        if (humidity > 80) {
            System.out.println("Alert: High humidity detected!");
        }
        
        if (temperature > 40) {
            System.out.println("Alert: Extreme heat detected!");
        }
        
        if (humidity < 20) {
            System.out.println("Alert: Low humidity detected!");
        }
        
    }
}
