package com.example.nikola.insomniac.statistics;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Tab1Fragment extends Fragment {
    private static final String TAG = "SleepQuality";
    DatabaseHelper databaseHelper;
    TrackProgress tp;

    ArrayList<String> variablaList = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);
        LineChart lineChart = (LineChart) view.findViewById(R.id.chart);
        databaseHelper = new DatabaseHelper(getActivity());
        tp = new TrackProgress();
        databaseHelper.addSleepQualityData("3","27-08-2017");
        databaseHelper.addSleepQualityData("2","28-08-2017");
        databaseHelper.addSleepQualityData("1","30-08-2017");
        databaseHelper.addNightlyLightData("3","27-08-2017");
        databaseHelper.addNightlyLightData("2","28-08-2017");

        databaseHelper.addNightlyLightData("4","30-08-2017");

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

        ArrayList<LineDataSet> lines = new ArrayList<>();

        if(tp.arrayList.size() > 0){
            for(int i = 0; i < tp.arrayList.size(); i++){
                Integer columnIndex = variables.indexOf(tp.arrayList.get(i));
                ArrayList<String> values = databaseHelper.getDataValues(tp.arrayList.get(i), columns.get(columnIndex));
                ArrayList<Entry> entries = new ArrayList<>();
                if(values.size() > 0) {
                    for (int j = 0; j < values.size(); j++) {
                        entries.add(new Entry(Integer.parseInt(values.get(j)), j));
                    }
                    if (entries.size() > graphSize) {
                        graphSize = entries.size();
                    }


                    LineDataSet dataSet = new LineDataSet(entries, tp.arrayList.get(i));
                    dataSet.setCircleColor(map.get(tp.arrayList.get(i)));
                    dataSet.setColor(map.get(tp.arrayList.get(i)));
                    dataSet.setDrawCubic(true);
                    dataSet.setDrawFilled(true);
                    lines.add(dataSet);
                }
            }
            ArrayList<String> xAxis = new ArrayList<>();

            for(int k = 0; k < graphSize; k++){
                xAxis.add(Integer.toString(k));
            }
            lineChart.setData(new LineData(xAxis, lines));
            lineChart.setGridBackgroundColor(Color.argb(50, 1, 0, 0));
            lineChart.animateY(5000);
        }
        return view;



    }
}
