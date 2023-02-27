package com.example.buildyourownui;

import static com.example.buildyourownui.GameActivity.mediaPlayerpunch;
import static com.example.buildyourownui.MainActivity.mediaPlayermain;
import static com.example.buildyourownui.MainActivity.mediaPlayermain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;


public class SettingsActivity extends AppCompat {
    // initializing variables
    private TextView lblGeneral, lblSettings;
    private Switch switchNightMode;
    private RadioButton rbEnglish, rbGerman;
    private Button btnChangeUserName;
    private ImageButton btnBack;
    private EditText eTUsername;
    public ToggleButton btnBackgroundMusic;
    private ToggleButton btnSounds;
    private Switch switchEasyHard;

    public static boolean switch_hardeasy,StateOfBackgroundMusic, stateOfSounds, StateOfEasyHard;

    private SharedPreferences BTNsharedPreferences;

    //public static boolean StateOfBackgroundMusic, StateOfSounds, StateOfEasyHard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_settings);

        // Variables from GUI
        lblGeneral = findViewById(R.id.lblGeneral);
        switchNightMode = findViewById(R.id.switchDarkMode);
        rbGerman = findViewById(R.id.rbGerman);
        rbEnglish = findViewById(R.id.rbEnglish);
        eTUsername = findViewById(R.id.eTUsername);
        btnChangeUserName = findViewById(R.id.btnChangeUserName);
        btnBack = findViewById(R.id.btnBack);

        btnSounds = findViewById(R.id.btnSounds);
        switchEasyHard = findViewById(R.id.switchEasyHard);


        // Java class
        LanguageManager lang = new LanguageManager( this);
        UsernameManager usernameManager = new UsernameManager(this);
        //SettingsManager settingsManager = new SettingsManager(this);

        /** Shared Preferences of Button State **/
        BTNsharedPreferences = getSharedPreferences("btn", Context.MODE_PRIVATE);
        updateBTN();
/*        switchEasyHard.setChecked(settingsManager.updateEasyHard());
        btnBackgroundMusic.setChecked(settingsManager.updateBTNBackgroundMusic());
        btnSounds.setChecked(settingsManager.updateBTNSounds());*/



        /** USERNAME */
        // set Username
        String user = usernameManager.getUser();
        eTUsername.setText(String.format(user));
        // change Username
        btnChangeUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // save Username
                String username = eTUsername.getText().toString();
                usernameManager.setUser(username);
                // set Username
                String user = usernameManager.getUser();
                eTUsername.setText(String.format(user));
            }
        });

/*        *//** Background music *//*
        StateOfBackgroundMusic = btnBackgroundMusic.isChecked();
        btnBackgroundMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBTNpref();
                //settingsManager.setBTNpref(StateOfEasyHard, StateOfSounds, StateOfBackgroundMusic);       //set Button Preferences
                if (StateOfBackgroundMusic == false){
                    mediaPlayermain.pause();
                }
                else {
                    mediaPlayermain.start();
                }
            }
        });*/

        /** Sounds */
        stateOfSounds = btnSounds.isChecked();
        btnSounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBTNpref();
                //settingsManager.setBTNpref(StateOfEasyHard, StateOfSounds, StateOfBackgroundMusic);       //set Button Preferences

            }
        });


        /** Language */
        // set right Radiobutton
        rbEnglish.setChecked(lang.UpdateRB("english"));
        rbGerman.setChecked(lang.UpdateRB("german"));

        // Check state of Radiobutton English
        rbEnglish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean english_isChecked) {
                lang.SavePreferencesRB("english", english_isChecked);
            }
        });

        // Check state of Radiobutton German
        rbGerman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean german_isChecked) {
                lang.SavePreferencesRB("german", german_isChecked);
            }
        });

        // set language to english
        rbEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lang.updateResourceLang("en");
                recreate();
            }
        });

        // set language to german
        rbGerman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lang.updateResourceLang("de");
                recreate();
            }
        });

        /** Darkmode */
        // Set DarkMode Theme
        switchNightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check current state of a toggle button (true or false).
                Boolean btnNightModeState = switchNightMode.isChecked();
                if (btnNightModeState == false) {
                    // changing the theme to light mode.
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else if (btnNightModeState == true){
                    // changing the theme to dark mode.
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
            }
        });

        // set DarkMode Switch
        int nightModeFlags =
                getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                switchNightMode.setChecked(true);
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                switchNightMode.setChecked(false);
                break;
        }

        /** Easy/Hard Mode */
        StateOfEasyHard = switchEasyHard.isChecked();
        switchEasyHard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Level hard
                    switch_hardeasy = true;
                    ScoreActivity.difficulty_score = "Hardmode";
                } else {
                    // Level easy
                    switch_hardeasy = false;
                    ScoreActivity.difficulty_score = "Easymode";
                }
                setBTNpref();
                // settingsManager.setBTNpref(StateOfEasyHard, StateOfSounds, StateOfBackgroundMusic);       //set Button Preferences
            }
        });



        /** Go to Main Menu */
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back
                Intent intentMain = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intentMain);
            }
        });

    }




    private void setBTNpref() {
        //SharedPreferences BTNsharedPreferences = getSharedPreferences("btn", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = BTNsharedPreferences.edit();
        editor.clear();
        editor.putBoolean("switchEasyHard", switchEasyHard.isChecked());
        editor.putString("StringEasyHard", ScoreActivity.difficulty_score);
       // editor.putBoolean("btnBackgroundMusic", btnBackgroundMusic.isChecked());
        editor.putBoolean("btnSounds", btnSounds.isChecked());
        editor.apply();

    }

    private void updateBTN(){
        switchEasyHard.setChecked(BTNsharedPreferences.getBoolean("switchEasyHard", false));
        //btnBackgroundMusic.setChecked(BTNsharedPreferences.getBoolean("btnBackgroundMusic", false));
        btnSounds.setChecked(BTNsharedPreferences.getBoolean("btnSounds", false));
    }

    public String getDifficultyMode(){
        return BTNsharedPreferences.getString("StringEasyHard", null);
    }

}
