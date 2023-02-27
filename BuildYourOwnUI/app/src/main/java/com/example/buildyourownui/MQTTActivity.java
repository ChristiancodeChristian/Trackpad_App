package com.example.buildyourownui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MQTTActivity extends AppCompatActivity implements MqttCallbackExtended {

    private MqttAndroidClient mqttClient;
    private final String brokerUrl = "38ba39232ed84410ace75a2b856b0842.s2.eu.hivemq.cloud";
    private final String clientId = "TrackPad";
    private final String topic = "esp32/score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create MQTT client
        mqttClient = new MqttAndroidClient(this, brokerUrl, clientId);
        mqttClient.setCallback(this);

        // connect to broker
        try {
            IMqttToken token = mqttClient.connect();
            token.waitForCompletion();
        } catch (MqttException e) {
            e.printStackTrace();
        }

        // subscribe to topic
        try {
            IMqttToken token = mqttClient.subscribe(topic, 0);
            token.waitForCompletion();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        // handle connection lost
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // handle incoming message
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // handle message delivery complete
    }

    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        // handle connection complete
    }
}
