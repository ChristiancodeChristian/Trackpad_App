package com.example.buildyourownui;

        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.Button;


public class SelectActivity extends AppCompat {
    // initializing variables
    private Button BTN_mobile, BTN_tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        // Variables from GUI
        BTN_mobile = findViewById(R.id.BTN_mobile);
        BTN_tp = findViewById(R.id.BTN_tp);

        };


    private void launchMainActivity(){
        Intent intent = new Intent(SelectActivity.this, MainActivity.class);
        startActivity(intent);
    }


}