package com.astraspecs.IoTControlBackend.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    @Bean
    public MqttClient mqttClient() throws MqttException {
        String broker = "tcp://localhost:8080";
        String clientId = "JavaBackendClient";
        MqttClient client = new MqttClient(broker, clientId) ;
        client.connect();
        return client;
    }
}
