package com.astraspecs.IoTControlBackend.repository;

import com.astraspecs.IoTControlBackend.deviceGroup.DeviceGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceGroupRepository  extends JpaRepository<DeviceGroup,Long> {

    DeviceGroup findByGroupName(String groupName);
}
