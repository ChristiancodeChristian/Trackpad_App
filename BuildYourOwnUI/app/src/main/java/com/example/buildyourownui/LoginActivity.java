package com.example.buildyourownui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompat {
    // initializing variables
    private EditText editUser;
    private Button btnStart;
    private TextView lblError;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Variables from GUI
        editUser = findViewById(R.id.editUser);
        btnStart = findViewById(R.id.btnStart);
        lblError = findViewById(R.id.lblError);

        // Java class
        UsernameManager usernameManager = new UsernameManager(this);


        // Open Main Menu
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Query: Username entered
                if (editUser.getText().toString().isEmpty()==false) {
                    // username entered
                    launchMainActivity();
                }
                else{
                    // no username entered
                    lblError.setVisibility(View.VISIBLE);
                }

                //save Username
                String username = editUser.getText().toString();
                usernameManager.setUser(username);
            }
        });

    }

    private void launchMainActivity(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }



}