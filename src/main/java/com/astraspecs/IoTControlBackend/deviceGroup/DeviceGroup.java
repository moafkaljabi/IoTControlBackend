package com.astraspecs.IoTControlBackend.deviceGroup;

import com.astraspecs.IoTControlBackend.device.Device;
import com.astraspecs.IoTControlBackend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "device_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class DeviceGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String groupName;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    @OneToMany(
            mappedBy = "deviceGroup",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Device> devices = new HashSet<>();

}
