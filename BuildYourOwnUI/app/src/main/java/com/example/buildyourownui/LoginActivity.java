package com.example.buildyourownui;

import android.content.Intent;
import android.media.MediaPlayer;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompat {
    // initializing variables
    private EditText editUser;
    private Button btnStart;
    private TextView lblError;

    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Variables from GUI
        editUser = findViewById(R.id.editUser);
        btnStart = findViewById(R.id.btnStart);
        lblError = findViewById(R.id.lblError);

        // Load the music file from the app's resources
        mediaPlayer = MediaPlayer.create(this, R.raw.loginmusicfile_1);

        // Loop the music continuously
        mediaPlayer.setLooping(true);

        // Start playing the music
        mediaPlayer.start();

        // Java class
        UsernameManager usernameManager = new UsernameManager(this);


        // Open Main Menu
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Query: Username entered
                if (editUser.getText().toString().isEmpty()==false) {
                    // username entered
                    launchMainActivity();
                    //launchSelectActivity();
                }
                else{
                    // no username entered
                    lblError.setVisibility(View.VISIBLE);
                }

                //save Username
                String username = editUser.getText().toString();
                usernameManager.setUser(username);
            }
        });

    }

    private void launchMainActivity(){
        Intent intent = new Intent(LoginActivity.this, SelectActivity.class);
        startActivity(intent);
    }
/*
    private void launchSelectActivity(){
    Intent intent = new Intent(LoginActivity.this, SelectActivity.class);
    startActivity(intent);
    }
*/

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Stop and release the MediaPlayer when the activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

}