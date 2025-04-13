package com.astraspecs.IoTControlBackend.controller;

import com.astraspecs.IoTControlBackend.device.Device;
import com.astraspecs.IoTControlBackend.service.DeviceService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor

public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping("/device")
    public Device getDevice(@PathVariable String deviceName){
        return deviceService.getDeviceByName(deviceName);
    }

    @PostMapping("/")
    public Device createDevice(@RequestBody Device device){
        return deviceService.saveDevice(device);
    }
}
