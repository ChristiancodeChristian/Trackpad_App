package com.example.buildyourownui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompat {
    // initializing variables
    private Button btnStart, btnGraph, btnScore1, btnExit;
    private ImageButton btnSettings;

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

        // open Settings Activity
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intentSettings);
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
                Intent intentGame = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intentGame);
            }
        });

        //open Score Activity
        btnScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentScore = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(intentScore);
            }
        });

        //close App
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish(); //exits the activity
            }
        });


    };

}