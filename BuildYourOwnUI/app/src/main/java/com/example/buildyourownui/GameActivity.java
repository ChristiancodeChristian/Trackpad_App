package com.example.buildyourownui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.os.SystemClock;



import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompat {
    // initializing variables
    private ImageButton btngame2main;

    private TextView scorecounter;
    private ImageButton Mole1,Mole2,Mole3,Mole4,Mole5,Mole6,Mole7,Mole8,Mole9;
    private Handler mHandler;
    private Runnable mRunnable;
    private TextView mCounterText;

    private List<ImageButton> buttons = new ArrayList<>();
    private Random random = new Random();
    private Handler handler = new Handler();
    private int activeButtonIndex = -1;
    private int mCounter = 0;

    private int speed;

    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayerpunch;

    public static boolean loadScore;

    TextView TextViewtime;
    long startTime = 0L;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    int t = 1;
    int secs = 0;
    int mins = 0;
    int milliseconds = 0;
    int difficulty;
    int easy = 5;
    int hard = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_game);

        // Variables from GUI
        btngame2main = findViewById(R.id.btngame2main);
        Mole1 = findViewById(R.id.Mole1);
        Mole2 = findViewById(R.id.Mole2);
        Mole3 = findViewById(R.id.Mole3);
        Mole4 = findViewById(R.id.Mole4);
        Mole5 = findViewById(R.id.Mole5);
        Mole6 = findViewById(R.id.Mole6);
        Mole7 = findViewById(R.id.Mole7);
        Mole8 = findViewById(R.id.Mole8);
        Mole9 = findViewById(R.id.Mole9);
        scorecounter = (TextView) findViewById(R.id.scorecount);
        TextViewtime = (TextView) findViewById(R.id.textViewtime);

        // Initialize handler and runnable for delayed color change
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                Mole1.setBackgroundColor(Color.parseColor("#888888"));
                Mole2.setBackgroundColor(Color.parseColor("#888888"));
                Mole3.setBackgroundColor(Color.parseColor("#888888"));
                Mole4.setBackgroundColor(Color.parseColor("#888888"));
                Mole5.setBackgroundColor(Color.parseColor("#888888"));
                Mole6.setBackgroundColor(Color.parseColor("#888888"));
                Mole7.setBackgroundColor(Color.parseColor("#888888"));
                Mole8.setBackgroundColor(Color.parseColor("#888888"));
                Mole9.setBackgroundColor(Color.parseColor("#888888"));
            }
        };

        // Load the music file from the app's resources
        mediaPlayer = MediaPlayer.create(this, R.raw.gamemusicfile_1);

        // Loop the music continuously
        mediaPlayer.setLooping(true);

        // Start playing the music
        mediaPlayer.start();

        // Load the music file from the app's resources
        mediaPlayerpunch = MediaPlayer.create(this, R.raw.punch);

        // Loop the music continuously
        mediaPlayerpunch.setLooping(false);

        startTime = SystemClock.uptimeMillis();
        handler.postDelayed(updateTimer, 0);



        for (int i = 1; i <= 9; i++) {
            int buttonId = getResources().getIdentifier("Mole" + i, "id", getPackageName());
            ImageButton Mole = findViewById(buttonId);
            //Mole.setOnClickListener(Mole1,Mole2,Mole3,Mole4,Mole5,Mole6,Mole7,Mole8,Mole9);
            Mole.setBackgroundColor(Color.GRAY);
            buttons.add(Mole);
        }


        scheduleRandomButtonActivation();


        // Set the button's click listener
        Mole1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerpunch.isPlaying()) {
                    mediaPlayerpunch.stop();
                }

                // Start playing the music
                mediaPlayerpunch.start();
                // increase Counter by 1
                incrementCounter();

                // Change button's background color to green
                Mole1.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);

                deactivateAllButtons();
            }
        });
        Mole2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerpunch.isPlaying()) {
                    mediaPlayerpunch.stop();
                }

                // Start playing the music
                mediaPlayerpunch.start();

                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole2.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
                deactivateAllButtons();
            }
        });
        Mole3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerpunch.isPlaying()) {
                    mediaPlayerpunch.stop();
                }

                // Start playing the music
                mediaPlayerpunch.start();

                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole3.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
                deactivateAllButtons();
            }
        });
        Mole4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerpunch.isPlaying()) {
                    mediaPlayerpunch.stop();
                }

                // Start playing the music
                mediaPlayerpunch.start();

                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole4.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
                deactivateAllButtons();
            }
        });
        Mole5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerpunch.isPlaying()) {
                    mediaPlayerpunch.stop();
                }

                // Start playing the music
                mediaPlayerpunch.start();

                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole5.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
                deactivateAllButtons();
            }
        });
        Mole6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerpunch.isPlaying()) {
                    mediaPlayerpunch.stop();
                }

                // Start playing the music
                mediaPlayerpunch.start();

                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole6.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
                deactivateAllButtons();
            }
        });
        Mole7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerpunch.isPlaying()) {
                    mediaPlayerpunch.stop();
                }

                // Start playing the music
                mediaPlayerpunch.start();

                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole7.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
                deactivateAllButtons();
            }
        });
        Mole8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerpunch.isPlaying()) {
                    mediaPlayerpunch.stop();
                }

                // Start playing the music
                mediaPlayerpunch.start();

                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole8.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
                deactivateAllButtons();
            }
        });
        Mole9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerpunch.isPlaying()) {
                    mediaPlayerpunch.stop();
                }

                // Start playing the music
                mediaPlayerpunch.start();

                // increase Counter by 1
                incrementCounter();
                // Change button's background color to green
                Mole9.setBackgroundColor(Color.GREEN);
                // Delayed color change back to gray after 1 second
                mHandler.postDelayed(mRunnable, 1000);
                deactivateAllButtons();
            }
        });


        btngame2main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back
                if (mediaPlayerpunch.isPlaying()) {
                    mediaPlayerpunch.stop();
                }

                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                Intent intentMain = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intentMain);
            }
        });
    }
    private void incrementCounter() {

        mCounter = mCounter +1;
        //mCounterText.setText("Counter: " + mCounter);
        scorecounter.setText(String.valueOf(mCounter));
        if (SettingsActivity.switch_hardeasy = true){
            difficulty = hard;
            speed = 3000;
        }
        else

            difficulty = easy;
            speed = 1000;

        if (mCounter >= difficulty) {
            // Launch a new activity when counter reaches 25

            ScoreActivity.time = "" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds);

            if (mediaPlayerpunch.isPlaying()) {
                mediaPlayerpunch.stop();
            }

            if(mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }

            if (mediaPlayerpunch != null) {
                mediaPlayerpunch.stop();
                mediaPlayerpunch.release();
            }
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            loadScore=true;
            Intent intentFin = new Intent(GameActivity.this, ScoreActivity.class);
            startActivity(intentFin);
        }
    }
    private void deactivateAllButtons() {
        for (ImageButton button : buttons) {
            button.setEnabled(false);
            button.setBackgroundColor(Color.GRAY);
            button.setImageResource(R.drawable.lustiger_maulwurf_im_garten_maulwurf_design_sticker);
        }
    }

    private void activateButton(int buttonIndex) {
        ImageButton button = buttons.get(buttonIndex);
        button.setEnabled(true);
        button.setBackgroundColor(Color.RED);
        activeButtonIndex = buttonIndex;
        button.setImageResource(R.drawable.mole_topo);
    }

    private void deactivateButton(int buttonIndex) {
        ImageButton button = buttons.get(buttonIndex);
        button.setEnabled(false);
        button.setBackgroundColor(Color.GRAY);
        activeButtonIndex = -1;
    }

    private void scheduleRandomButtonActivation() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int buttonIndex = random.nextInt(buttons.size());
                activateButton(buttonIndex);
                scheduleRandomButtonActivation();
            }
        },
                random.nextInt(1000) + 1);
    }

    public void onClick(View view) {
        for (int i = 0; i < buttons.size(); i++) {
            if (view == buttons.get(i)) {
                if (i == activeButtonIndex) {
                    deactivateButton(activeButtonIndex);
                }
                break;
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove any pending delayed color changes when activity is destroyed
        mHandler.removeCallbacks(mRunnable);
        // Stop and release the MediaPlayer when the activity is destroyed


    }

    public Runnable updateTimer = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            secs = (int) (updatedTime / 1000);
            mins = secs / 60;
            secs = secs % 60;
            milliseconds = (int) (updatedTime % 1000);
            TextViewtime.setText("" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds));
            handler.postDelayed(this, 0);
        }
    };
}
