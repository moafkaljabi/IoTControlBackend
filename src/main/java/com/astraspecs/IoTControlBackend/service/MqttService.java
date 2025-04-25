package com.astraspecs.IoTControlBackend.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttService {

    private final static Logger logger = LoggerFactory.getLogger(MqttService.class);

    private final MqttClient mqttClient;

    @Autowired
    public MqttService(MqttClient mqttClient){
        this.mqttClient = mqttClient;
        subscribeToTopics();
    }

    public void publish(String topic, String payload){
        try {
            MqttMessage message = new MqttMessage(payload.getBytes());
            mqttClient.publish(topic,message);
        } catch(MqttException e){
            logger.error("Failed to publish MQTT message",e);
        }
    }

    private void subscribeToTopics(){
        try {
            mqttClient.subscribe("telemetry/#",(topic,msg) -> {
                String payload = new String(msg.getPayload());
                logger.info("Received MQTT message: {} -> {}", topic, payload);
                // TODO: Parse JSON and forward to DeviceService.
                JSONPObject jsonpObject;
            });
        } catch(MqttException e){
            logger.error("Failed to subscribe to MQTT topic",e);
        }
    }

}
