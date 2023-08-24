package com.christina.sensor.kafka;

import com.christina.sensor.model.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SensorDataProducer {

    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    private static final String TOPIC = "IoT-driven Green Roof";

    @Autowired
    public SensorDataProducer(KafkaTemplate<String, SensorData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendSensorData(SensorData sensorData) {
        kafkaTemplate.send(TOPIC, sensorData.getSensorId(), sensorData);
    }
}
