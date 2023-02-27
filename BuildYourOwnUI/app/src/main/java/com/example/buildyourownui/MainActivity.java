package com.example.buildyourownui;

import static com.example.buildyourownui.GameActivity.mediaPlayergame;
import static com.example.buildyourownui.SelectActivity.gameModi;
import static com.example.buildyourownui.SettingsActivity.StateOfBackgroundMusic;
import static com.example.buildyourownui.SettingsActivity.stateOfSounds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.media.MediaPlayer;
import android.widget.ToggleButton;


public class MainActivity extends AppCompat {
    // initializing variables
    private Button btnStart, btnGraph, btnScore1, btnExit;
    private ImageButton btnSettings;


    public static MediaPlayer mediaPlayermain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variables from GUI
        btnExit = findViewById(R.id.btnExit);
        btnStart = findViewById(R.id.btnStartMain);
        btnSettings = findViewById(R.id.btnSettings);
        btnGraph = findViewById(R.id.btnGraph);
        btnScore1 = findViewById(R.id.btnScore1);


        // Load the music file from the app's resources
        mediaPlayermain = MediaPlayer.create(this, R.raw.loginmusicfile_1);

        // Loop the music continuously
        mediaPlayermain.setLooping(true);


        if (!stateOfSounds){
            // Start playing the music
            mediaPlayermain.start();
        }
      /*  if(stateOfSounds){
            if(mediaPlayermain.isPlaying()){
                mediaPlayermain.stop();
            }
            if (mediaPlayermain != null) {
                mediaPlayermain.stop();
                mediaPlayermain.release();
            }
        }*/







        // open Settings Activity
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intentSettings);

                if (mediaPlayermain != null) {
                    mediaPlayermain.stop();
                    mediaPlayermain.release();
                }
            }
        });

        //open Graph Activity
        btnGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGraph = new Intent(MainActivity.this, GraphActivity.class);
                startActivity(intentGraph);
            }
        });

        //open Game Activity
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gameModi == false){
                    Intent intentGame = new Intent(MainActivity.this, GameActivity.class);
                    startActivity(intentGame);
                }
                else{
                    Intent intentGame = new Intent(MainActivity.this, GameTrackpadActivity.class);
                    startActivity(intentGame);
                }

            }
        });

        //open Score Activity
        btnScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mediaPlayermain != null) {
                    mediaPlayermain.stop();
                    mediaPlayermain.release();
                }
                Intent intentScore = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(intentScore);
            }
        });



        //close App
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finishAffinity();
            }
        });
        //exits the activity

    };
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Stop and release the MediaPlayer when the activity is destroyed


        if (mediaPlayermain != null) {
            mediaPlayermain.stop();
            mediaPlayermain.release();
        }
    }

}