package com.example.buildyourownui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GraphActivity extends AppCompat {
    // initializing variables
    private Button btnGraph2Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_graph);

        // Variables from GUI
        btnGraph2Score = findViewById(R.id.btnGraph2Score);

        //open Score Activity
        btnGraph2Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentScore = new Intent(GraphActivity.this, ScoreActivity.class);
                startActivity(intentScore);
            }
        });
    }
}
