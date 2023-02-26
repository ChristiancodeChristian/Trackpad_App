package com.example.buildyourownui;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class TestActivity extends AppCompat {

    private BarChart chart;
    private TextView scoreTimeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        chart = findViewById(R.id.barChartscore);
        //scoreTimeText = findViewById(R.id.score_time_text);

        // Set up the chart
        chart.getDescription().setEnabled(false);
        chart.setDrawGridBackground(false);
        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.setPinchZoom(false);
        chart.setDrawGridBackground(false);
        chart.setTouchEnabled(false);
        chart.setDoubleTapToZoomEnabled(false);

        // Create a data set with a single bar
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 0f));
        BarDataSet dataSet = new BarDataSet(entries, "Score");

        // Customize the data set
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(16f);

        // Create a data object with the data set
        BarData data = new BarData(dataSet);
        data.setBarWidth(0.9f);

        // Set the data object to the chart
        chart.setData(data);
    }
}

