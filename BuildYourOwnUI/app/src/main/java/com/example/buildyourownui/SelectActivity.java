package com.example.buildyourownui;

        import android.content.Intent;
        import android.media.MediaPlayer;
        //import android.support.v7.app.LoginActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.ImageButton;


public class SelectActivity extends AppCompat {
    // initializing variables
    private Button BTN_mobile, BTN_tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_choise);

        // Variables from GUI
//        BTN_mobile = findViewById(R.id.btnExit);
//        BTN_tp = findViewById(R.id.btnStartMain);

        };


    private void launchMainActivity(){
        Intent intent = new Intent(SelectActivity.this, MainActivity.class);
        startActivity(intent);
    }


}