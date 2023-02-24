package com.example.buildyourownui;

//package com.github.mikephil.charting.charts;
import com.github.mikephil.charting.charts.GraphHelper;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.github.mikephil.charting.charts.GraphHelper;

import java.util.ArrayList;
import java.util.List;

public class GraphActivity extends AppCompat {
    // initializing variables
    private Button btnGraph2Score;
    private ImageButton btnGraph2Home;
    private List<BarEntry> barArraylist;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_graph);


        // Variables from GUI
        btnGraph2Score = findViewById(R.id.btnGraph2Score);
        btnGraph2Home = findViewById(R.id.imbtnGraph_Home);


        //GraphHelper graphHelper = new GraphHelper( this);

        BarChart barChart = findViewById(R.id.barchart);
        getData();
        BarDataSet barDataSet = new BarDataSet(barArraylist,"Cambo Tutorial");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        //color bar data set
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //text color
        barDataSet.setValueTextColor(Color.BLACK);
        //setting text size
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(true);





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
