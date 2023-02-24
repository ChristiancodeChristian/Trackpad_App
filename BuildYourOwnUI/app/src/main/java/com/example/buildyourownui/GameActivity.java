package com.example.buildyourownui;

import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class GameActivity extends AppCompat {
    // initializing variables
    private ImageButton btngame2main;

    private TextView scorecounter;
    private ImageButton Mole1_1,Mole1_2,Mole1_3,Mole2_1,Mole2_2,Mole2_3,Mole3_1,Mole3_2,Mole3_3;
    private Handler mHandler;
    private Runnable mRunnable;
    private TextView mCounterText;

    private int mCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_game);

        // Variables from GUI
        btngame2main = findViewById(R.id.btngame2main);
        Mole1_1 = findViewById(R.id.Mole1_1);
        Mole1_2 = findViewById(R.id.Mole1_2);
        Mole1_3 = findViewById(R.id.Mole1_3);
        Mole2_1 = findViewById(R.id.Mole2_1);
        Mole2_2 = findViewById(R.id.Mole2_2);
        Mole2_3 = findViewById(R.id.Mole2_3);
        Mole3_1 = findViewById(R.id.Mole3_1);
        Mole3_2 = findViewById(R.id.Mole3_2);
        Mole3_3 = findViewById(R.id.Mole3_3);
        scorecounter = (TextView) findViewById(R.id.scorecount);

        // Initialize handler and runnable for delayed color change
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                Mole1_1.setBackgroundColor(Color.parseColor("#888888"));
                Mole1_2.setBackgroundColor(Color.parseColor("#888888"));
                Mole1_3.setBackgroundColor(Color.parseColor("#888888"));
                Mole2_1.setBackgroundColor(Color.parseColor("#888888"));
                Mole2_2.setBackgroundColor(Color.parseColor("#888888"));
                Mole2_3.setBackgroundColor(Color.parseColor("#888888"));
                Mole3_1.setBackgroundColor(Color.parseColor("#888888"));
                Mole3_2.setBackgroundColor(Color.parseColor("#888888"));
                Mole3_3.setBackgroundColor(Color.parseColor("#888888"));
            }
        };

        // Set the button's click listener
        Mole1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole1_1.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
            }
        });
        Mole1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole1_2.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
            }
        });
        Mole1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole1_3.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
            }
        });
        Mole2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole2_1.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
            }
        });
        Mole2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole2_2.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
            }
        });
        Mole2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole2_3.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
            }
        });
        Mole3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole3_1.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
            }
        });
        Mole3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole3_2.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
            }
        });
        Mole3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole3_3.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
            }
        });


        btngame2main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back
                Intent intentMain = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intentMain);
            }
        });
    }
    private void incrementCounter() {

        mCounter = mCounter +1;
        //mCounterText.setText("Counter: " + mCounter);
        scorecounter.setText(String.valueOf(mCounter));

        if (mCounter >= 25) {
            // Launch a new activity when counter reaches 25
            Intent intentFin = new Intent(GameActivity.this, ScoreActivity.class);
            startActivity(intentFin);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove any pending delayed color changes when activity is destroyed
        mHandler.removeCallbacks(mRunnable);
    }
}
