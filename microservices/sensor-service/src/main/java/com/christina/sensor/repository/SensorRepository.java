package com.christina.sensor.repository;

import com.christina.sensor.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SensorRepository extends JpaRepository<SensorData, Long> {
    
    List<SensorData> findBySensorId(String sensorId);

    @Query("SELECT s FROM SensorData s WHERE s.temperature >= :minTemperature")
    List<SensorData> findByMinTemperature(double minTemperature);
}
