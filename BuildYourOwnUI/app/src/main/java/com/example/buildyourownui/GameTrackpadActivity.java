package com.example.buildyourownui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameTrackpadActivity extends AppCompat{

    private Button btnLetsGo;
    private TextView lblGameTrackpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_trackpad);

        // Variables from GUI
        btnLetsGo = findViewById(R.id.btnLetsGo);
        lblGameTrackpad = findViewById(R.id.lblGameTrackpad);

        btnLetsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblGameTrackpad.setText(getResources().getString(R.string.luck));
                btnLetsGo.setVisibility(View.GONE);

                //sent start command to Trackpad over MQTT


            }
        });
    }
}

/*

public class GametrackpadActivity extends AppCompatActivity {

    private MQTTActivity mqttActivity;
    private final String topic = "esp32/command";
    private final String message = "start";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create MQTT activity
        mqttActivity = new MQTTActivity();

        // send message to ESP32
        try {
            mqttActivity.mqttClient.publish(topic, message.getBytes(), 0, false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}

 */