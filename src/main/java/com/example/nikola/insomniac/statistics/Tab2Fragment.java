package com.example.nikola.insomniac.statistics;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";
    DatabaseHelper databaseHelper;

    TrackProgress tp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);
        LineChart lineChart = (LineChart) view.findViewById(R.id.chart2);
        tp = new TrackProgress();
        databaseHelper = new DatabaseHelper(getActivity());

        Map<String, String> map = new HashMap<>();
        map.put("SleepQuality", "SleepQuality");
        map.put("DailyLight", "AverageLux");
        map.put("NightlyLight", "AverageLux");
        map.put("PhysicalActivity", "Sport");
        map.put("Water", "WaterAmount");
        map.put("Coffee", "CoffeeAmount");
        map.put("Bedroom", "Humidity");

        ArrayList<String> xAxis = databaseHelper.getDataValues("SleepQuality", "SleepQuality");
        ArrayList<String> yAxis = databaseHelper.getDataValues(tp.corelation, map.get(tp.corelation));
        ArrayList<Entry> entries = new ArrayList<>();
        if (yAxis.size() > 0) {
            for (int j = 0; j < yAxis.size(); j++) {
                entries.add(new Entry(Integer.parseInt(yAxis.get(j)),Integer.parseInt(xAxis.get(j))));
            }


            LineDataSet dataSet = new LineDataSet(entries, tp.corelation);
            dataSet.setCircleColor(Color.BLUE);
            dataSet.setColor(Color.BLUE);
            dataSet.setDrawCubic(true);
            dataSet.setDrawFilled(true);
            LineData data = new LineData(xAxis, dataSet);

            lineChart.setData(data);
            lineChart.animateY(5000);
        }
        return view;

    }
}
