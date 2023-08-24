package com.christina.sensor.service;

import com.christina.sensor.model.SensorData;
import com.christina.sensor.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public void saveSensorData(SensorData sensorData) {
        sensorRepository.save(sensorData);
    }
}
