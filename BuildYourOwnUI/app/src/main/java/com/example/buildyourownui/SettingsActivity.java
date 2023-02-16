package com.example.buildyourownui;

import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;



public class SettingsActivity extends AppCompat {
    // initializing variables
    private TextView lblGeneral, lblSettings;
    private Switch switchNightMode;
    private RadioButton rbEnglish, rbGerman;
    private Button btnChangeUserName, btnBack;
    private EditText eTUsername;


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

        // Java class
        LanguageManager lang = new LanguageManager( this);
        UsernameManager usernameManager = new UsernameManager(this);


        //!!USERNAME!!
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


        // !!LANGUAGE!!
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

        // !!DARKMODE!!
        // DarkMode Click
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

        // !!Back!!
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back
            }
        });

    }


    ;
}