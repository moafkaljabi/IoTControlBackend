package com.astraspecs.IoTControlBackend.service;

import com.astraspecs.IoTControlBackend.device.Device;
import com.astraspecs.IoTControlBackend.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DeviceService {

    private final DeviceRepository deviceRepository;

    public Device getDeviceByName(String deviceName){
        return deviceRepository.findByDeviceName(deviceName);
    }

    public Device saveDevice(Device device){
        return deviceRepository.save(device);
    }
}
