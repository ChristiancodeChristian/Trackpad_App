package com.example.buildyourownui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompat {
    // initializing variables
    private Button btnStart, btnGraph, btnScore, btnExit;
    private ImageButton btnSettings;

    //public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variables from GUI
        btnExit = findViewById(R.id.btnExit);
        btnStart = findViewById(R.id.btnStartMain);
        btnSettings = findViewById(R.id.btnSettings);
        btnGraph = findViewById(R.id.btnGraph);
        btnScore = findViewById(R.id.btnScores);

/*        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fragment_container)!=null){

            if(savedInstanceState!=null){return;}
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.fragment_container, homeFragment, null);
            fragmentTransaction.commit();
        }*/

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        //open Graph Activity
        btnGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                //Intent intent = new Intent(MainActivity.this, GraphActivity.class);
                //startActivity(intent);
            }
        });

        //open Game Activity
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, GameActivity.class);
                //startActivity(intent);
            }
        });

        //open Score Activity
        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                //startActivity(intent);
            }
        });


    }


    ;
}