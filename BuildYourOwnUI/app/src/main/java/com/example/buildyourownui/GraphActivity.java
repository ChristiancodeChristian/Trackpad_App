package com.example.buildyourownui;

//package com.github.mikephil.charting.charts;
//import com.github.mikephil.charting.charts.GraphHelper;

/*import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.utils.ColorTemplate;

import com.github.mikephil.charting.utils.ColorTemplate;*/



import static com.example.buildyourownui.SettingsActivity.stateOfSounds;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

//import com.github.mikephil.charting.charts.GraphHelper;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class GraphActivity extends AppCompat {
    // initializing variables
    private Button btnGraph2Score;
    private ImageButton btnGraph2Home;
   // private List<BarEntry> barArraylist;
    private BarChart barChartscore;
    private BarChart barchartreacttime;
    private BarChart chart;

    private MediaPlayer mediaPlayer;
    ArrayList barArraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_graph);


        // Variables from GUI
        btnGraph2Score = findViewById(R.id.btnGraph2Score);
        btnGraph2Home = findViewById(R.id.imbtnGraph_Home);
        barChartscore = findViewById(R.id.barChartscore);
        barchartreacttime = findViewById(R.id.barChartreacttime);


        // Load the music file from the app's resources
        mediaPlayer = MediaPlayer.create(this, R.raw.loginmusicfile_1);

        // Loop the music continuously
        mediaPlayer.setLooping(true);
        if (stateOfSounds){
            // Start playing the music
            mediaPlayer.start();
        }
        if(!stateOfSounds){
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
        }
        // Start playing the music


        // Set up the barchartscore chart
        barChartscore.getDescription().setEnabled(true);
        barChartscore.setDrawGridBackground(true);
        barChartscore.setDrawBarShadow(true);
        barChartscore.setDrawValueAboveBar(true);
        barChartscore.setPinchZoom(true);
        barChartscore.setDrawGridBackground(true);
        barChartscore.setTouchEnabled(true);
        barChartscore.setDoubleTapToZoomEnabled(true);

        // Create a data set with a single bar
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30.358f));
        entries.add(new BarEntry(1f, 24.698f));
        entries.add(new BarEntry(2f, 42.545f));
        entries.add(new BarEntry(3f, 50.635f));
        entries.add(new BarEntry(4f, 65.655f));
        entries.add(new BarEntry(5f, 70.554f));
        entries.add(new BarEntry(6f, 35.650f));


        BarDataSet dataSet = new BarDataSet(entries, "Easymode || Time / Seconds");

        // Customize the data set
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(16f);

        // Create a data object with the data set
        BarData data = new BarData(dataSet);
        data.setBarWidth(0.9f);

        // Set the data object to the chart
        barChartscore.setData(data);


        // Set up the barchartreacttime chart
        barchartreacttime.getDescription().setEnabled(true);
        barchartreacttime.setDrawGridBackground(true);
        barchartreacttime.setDrawBarShadow(true);
        barchartreacttime.setDrawValueAboveBar(true);
        barchartreacttime.setPinchZoom(true);
        barchartreacttime.setDrawGridBackground(true);
        barchartreacttime.setTouchEnabled(true);
        barchartreacttime.setDoubleTapToZoomEnabled(true);

        // Create a data set with a single bar
        ArrayList<BarEntry> entries2 = new ArrayList<>();
        entries2.add(new BarEntry(0f, 80.534f));
        entries2.add(new BarEntry(1f, 100.547f));
        entries2.add(new BarEntry(2f, 95.525f));
        entries2.add(new BarEntry(3f, 102.424f));


        BarDataSet dataSet2 = new BarDataSet(entries2, "Hardmode || Time /Seconds");

        // Customize the data set
        dataSet2.setColor(Color.BLUE);
        dataSet2.setValueTextColor(Color.BLACK);
        dataSet2.setValueTextSize(16f);

        // Create a data object with the data set
        BarData data2 = new BarData(dataSet2);
        data2.setBarWidth(0.9f);

        // Set the data object to the chart
        barchartreacttime.setData(data2);






        //open Score Activity
        btnGraph2Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentScore = new Intent(GraphActivity.this, ScoreActivity.class);
                startActivity(intentScore);
            }
        });

        btnGraph2Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                Intent intentMain = new Intent(GraphActivity.this, MainActivity.class);
                startActivity(intentMain);
            }
        });
    }
    private void getData()
    {
        ArrayList barArraylist = new ArrayList();
        barArraylist.add(new BarEntry(2f,10));
        barArraylist.add(new BarEntry(3f,20));
        barArraylist.add(new BarEntry(4f,30));
        barArraylist.add(new BarEntry(5f,40));
        barArraylist.add(new BarEntry(6f,50));

    }

}
