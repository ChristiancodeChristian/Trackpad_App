package com.example.buildyourownui;

import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GameActivity extends AppCompat {
    // initializing variables
    private ImageButton btngame2main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_game);

        // Variables from GUI


        btngame2main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back
                Intent intentMain = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intentMain);
            }
        });
    }

}
