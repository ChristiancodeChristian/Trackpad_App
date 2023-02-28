package com.example.buildyourownui;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;


public class SelectActivity extends AppCompat {
    // initializing variables
    private Button BTN_mobile, BTN_tp;

    public static boolean gameModi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        // Variables from GUI
        BTN_mobile = findViewById(R.id.BTN_mobile);
        BTN_tp = findViewById(R.id.BTN_tp);

        BTN_mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameModi = false;
                launchMainActivity();
            }
        });

        BTN_tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameModi = true;
                launchMQTTActivity();
            }
        });

        };


    private void launchMainActivity(){
        Intent intent = new Intent(SelectActivity.this, MainActivity.class);
        startActivity(intent);
    }
    private void launchMQTTActivity(){
        Intent intent = new Intent(SelectActivity.this, MqttActivity.class);
        startActivity(intent);
    }

}