package com.astraspecs.IoTControlBackend.service;

import com.astraspecs.IoTControlBackend.deviceGroup.DeviceGroup;
import com.astraspecs.IoTControlBackend.repository.DeviceGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DeviceGroupService     {

    private final DeviceGroupRepository deviceGroupRepository;

    public DeviceGroup findByGroupName(String groupName){
        return deviceGroupRepository.findByGroupName(groupName);
    }

    public DeviceGroup saveGroup(DeviceGroup deviceGroup){
        return deviceGroupRepository.save(deviceGroup);
    }
}
