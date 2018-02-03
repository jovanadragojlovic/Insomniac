package com.example.nikola.insomniac.statistics;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.nikola.insomniac.R.id.chart;

public class Tab1Fragment extends Fragment {
    private static final String TAG = "SleepQuality";
    DatabaseHelper databaseHelper;
    TrackProgress tp;

    ArrayList<String> variablaList = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);
        BarChart barChart = (BarChart) view.findViewById(chart);
        databaseHelper = new DatabaseHelper(getActivity());
        tp = new TrackProgress();




        ArrayList<String> variables = new ArrayList<String>(){{add("SleepQuality"); add("DailyLight"); add("NightlyLight"); add("PhysicalActivity"); add("Water"); add("Coffee"); add("Bedroom");}};
        ArrayList<String> columns = new ArrayList<String>(){{add("SleepQuality"); add("AverageLux"); add("AverageLux"); add("Sport"); add("WaterAmount"); add("CoffeeAmount"); add("Humidity");}};
        ArrayList<Integer> colors = new ArrayList<Integer>(){{add(Color.WHITE); add(Color.BLUE); add(Color.RED);add(Color.YELLOW); add(Color.GREEN); add(Color.BLACK); add(Color.GRAY); }};

        Integer graphSize = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("SleepQuality", Color.WHITE);
        map.put("DailyLight", Color.RED);
        map.put("NightlyLight", Color.YELLOW);
        map.put("PhysicalActivity",Color.GREEN);
        map.put("Water", Color.BLUE);
        map.put("Coffee", Color.BLACK);
        map.put("Bedroom", Color.MAGENTA);

        Integer columnIndex = variables.indexOf(tp.clickedVar);
        ArrayList<String> values = databaseHelper.getDataValues(tp.clickedVar, columns.get(columnIndex));
        final ArrayList<String> dates = databaseHelper.getDataValues(tp.clickedVar, "Date");

        ArrayList<BarEntry> entries = new ArrayList<>();
        if(values.size() > 0) {
            for (int j = 0; j < values.size(); j++) {
                entries.add(new BarEntry(Integer.parseInt(values.get(j)), j));
            }
            if (entries.size() > graphSize) {
                graphSize = entries.size();
            }


            BarDataSet dataSet = new BarDataSet(entries, tp.clickedVar);
            dataSet.setColor(map.get(tp.clickedVar));
            dataSet.setValueTextColor(Color.WHITE);
            dataSet.setBarSpacePercent(90f);


            ArrayList<String> xAxis = new ArrayList<>();
            for(int k = 0; k < graphSize; k++){
                xAxis.add(dates.get(k));
            }
            barChart.setData(new BarData(xAxis,dataSet));
            barChart.getXAxis().setTextColor(Color.WHITE);
            barChart.getAxisRight().setTextColor(Color.WHITE);
            barChart.getAxisLeft().setTextColor(Color.WHITE);

            barChart.setVisibleXRange(1,4);
            barChart.getAxisRight().setDrawGridLines(false);
            barChart.getAxisLeft().setDrawLabels(false);
            barChart.getAxisRight().setDrawLabels(false);


            barChart.setDescription("");
            barChart.setDescriptionColor(Color.WHITE);
            barChart.getLegend().setTextColor(Color.WHITE);
            barChart.invalidate();
            barChart.setDrawGridBackground(true);
            barChart.setDrawBorders(true);
            barChart.setBorderColor(Color.WHITE);
            barChart.setGridBackgroundColor(Color.argb(50, 1, 0, 0));


        }



        return view;



    }
}
