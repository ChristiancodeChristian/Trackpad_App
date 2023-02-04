package com.example.buildyourownui;

import static android.R.layout.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;

import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.Spinner;

import android.view.View;

import android.widget.AdapterView;

import android.widget.TextView;
import android.widget.Toast;

import android.widget.AutoCompleteTextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    // initializing variables
    private TextView lblGeneral;
    private ToggleButton btnNightMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variables from GUI
        lblGeneral = findViewById(R.id.lblGeneral);
        btnNightMode = findViewById(R.id.btnNightMode);
        AutoCompleteTextView autocompleteTV = findViewById(R.id.autoCompleteTextView);

        // DropDown Menu Language
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.languages, simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        autocompleteTV.setAdapter(adapter);

        // DarkMode Click
        btnNightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check current state of a toggle button (true or false).
                Boolean btnNightModeState = btnNightMode.isChecked();
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


    }






    ;
}