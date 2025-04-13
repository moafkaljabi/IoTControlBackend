package com.astraspecs.IoTControlBackend.repository;

import com.astraspecs.IoTControlBackend.device.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    Device findByDeviceName(String deviceName);
}
