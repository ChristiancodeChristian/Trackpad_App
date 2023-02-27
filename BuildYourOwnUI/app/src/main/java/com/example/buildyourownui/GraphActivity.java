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

        // Start playing the music
        mediaPlayer.start();

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
        entries.add(new BarEntry(0f, 0f));
        entries.add(new BarEntry(0f, 10f));
        entries.add(new BarEntry(1f, 30f));
        entries.add(new BarEntry(2f, 50f));
        entries.add(new BarEntry(3f, 80f));
        entries.add(new BarEntry(4f, 10f));
        entries.add(new BarEntry(5f, 60f));
        entries.add(new BarEntry(6f, 20f));
        entries.add(new BarEntry(7f, 100f));
        entries.add(new BarEntry(8f, 80f));
        entries.add(new BarEntry(9f, 10f));
        entries.add(new BarEntry(10f, 60f));
        entries.add(new BarEntry(11f, 20f));
        entries.add(new BarEntry(12f, 100f));

        BarDataSet dataSet = new BarDataSet(entries, "Score");

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
        barchartreacttime.getDescription().setEnabled(false);
        barchartreacttime.setDrawGridBackground(false);
        barchartreacttime.setDrawBarShadow(false);
        barchartreacttime.setDrawValueAboveBar(true);
        barchartreacttime.setPinchZoom(false);
        barchartreacttime.setDrawGridBackground(false);
        barchartreacttime.setTouchEnabled(false);
        barchartreacttime.setDoubleTapToZoomEnabled(false);

        // Create a data set with a single bar
        ArrayList<BarEntry> entries2 = new ArrayList<>();
        entries2.add(new BarEntry(0f, 10f));
        entries2.add(new BarEntry(1f, 30f));
        entries2.add(new BarEntry(2f, 20f));
        entries2.add(new BarEntry(3f, 70f));


        BarDataSet dataSet2 = new BarDataSet(entries2, "Reacttime / Seconds");

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
