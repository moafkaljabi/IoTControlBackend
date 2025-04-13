package com.astraspecs.IoTControlBackend.controller;

import com.astraspecs.IoTControlBackend.deviceGroup.DeviceGroup;
import com.astraspecs.IoTControlBackend.service.DeviceGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device-groups")
@RequiredArgsConstructor

public class DeviceGroupController {

    private final DeviceGroupService deviceGroupService;

    @GetMapping("/{groupName}")
    public DeviceGroup getDeviceGroup(@PathVariable String deviceGroupName){
        return deviceGroupService.findByGroupName(deviceGroupName);
    }

    @PostMapping("/")
    public DeviceGroup createDeviceGroup(@RequestBody DeviceGroup deviceGroup){
        return deviceGroupService.saveGroup(deviceGroup);
    }

}
