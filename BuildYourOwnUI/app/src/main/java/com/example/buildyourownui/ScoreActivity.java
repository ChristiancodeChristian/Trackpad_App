package com.example.buildyourownui;

import static com.example.buildyourownui.GameActivity.loadScore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ScoreActivity extends AppCompat {
    public static String difficulty_score;
    // initializing variables
    private Button btnScore2Graph;

    private ImageButton btnBackScore;
    private ArrayAdapter<String> listAdapterEvents;
    private ArrayList<String> listData;
    private ListView listViewEvents;
    public static String time;
    private TextView test2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_score);

        // Variables from GUI
        btnScore2Graph = findViewById(R.id.btnScore2Graph);
        listViewEvents = findViewById(R.id.listViewEvents);
        btnBackScore = findViewById(R.id.btnscore2home);
        test2000 = findViewById(R.id.test2000);
        // Java class
        UsernameManager usernameManager = new UsernameManager(this);




        //open Graph Activity
        btnScore2Graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGraph = new Intent(ScoreActivity.this, GraphActivity.class);
                startActivity(intentGraph);
            }
        });

        btnBackScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back
                Intent intentMain = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intentMain);
            }
        });

        /** List View */
        //Create list data storage (String)
        listData = new ArrayList<>();
        //Create ArrayAdapter to display a list of texts (String)
        listAdapterEvents = new ArrayAdapter<>(this, R.layout.simple_list_item, listData);

        //Set adapter to be used by list view
        listViewEvents.setAdapter(listAdapterEvents);

        // load old score list
        loadContent();
        if (SettingsActivity.StateOfEasyHard==true) {
            test2000.setText("hard");
       }
        else {
            test2000.setText("easy");
        }

        //Test of list:

        if (loadScore==true){
            String user = usernameManager.getUser();

            //boolean dif = settingsManager.updateEasyHard();
            //String difficulty = settingsManager.getDifficultyMode();
            String difficulty;
            if (SettingsActivity.StateOfEasyHard==true) {
                test2000.setText("hard");
                difficulty = "hard";
            }
            else {
                difficulty = "easy";
                test2000.setText("easy");
            }
            // put new item to score list
            addListItem(user, difficulty, time );
            loadScore=false;
        }
    }

    public void addListItem(String user, String difficulty_score, String time){
        //combine timestamp and parameter
        listData.add(String.format("%s %s %s", user, difficulty_score, time));

        //notify the adapter that the underlying data has changed
        listAdapterEvents.notifyDataSetChanged();
    }

    public void loadContent(){
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path, "list.txt");
        byte[] content = new byte[(int) readFrom.length()];

        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(content);

            String s = new String(content);
            s = s.substring(1, s.length() - 1);
            String split[] = s.split(", ");

            listData = new ArrayList<>(Arrays.asList(split));
            listAdapterEvents = new ArrayAdapter<>(this, R.layout.simple_list_item, listData);
            listViewEvents.setAdapter(listAdapterEvents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        File path = getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, "list.txt"));
            writer.write(listData.toString().getBytes());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
