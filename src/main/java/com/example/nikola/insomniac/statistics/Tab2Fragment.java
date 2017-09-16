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
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2";
    DatabaseHelper databaseHelper;

    TrackProgress tp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);
        LineChart lineChart = (LineChart) view.findViewById(R.id.chart2);
        tp = new TrackProgress();
        databaseHelper = new DatabaseHelper(getActivity());

//        List<String> dates = databaseHelper.getDataValues("SleepQuality", "Date");
//        ArrayList<String> listX = new ArrayList<>();
//        List<String> listY = new ArrayList<>();
//        if(tp.corelation !="") {
//
//            for (String date : dates) {
//                String sq = databaseHelper.getSleepQualityByDate(date);
//                String value = null;
//                switch (tp.corelation) {
//                    case "DailyLight":
//                        value = databaseHelper.getDailyLightByDate(date);
//                        break;
//                    case "NightlyLight":
//                        value = databaseHelper.getNightlyLightByDate(date);
//                        break;
//                    case "PhysicalActivity":
//                        value = databaseHelper.getSportByDate(date);
//                        break;
//                    case "Water":
//                        value = databaseHelper.getWaterByDate(date);
//                        break;
//                    case "Coffee":
//                        value = databaseHelper.getCoffeeByDate(date);
//                        break;
//                    case "Bedroom":
//                        value = databaseHelper.getHumidityByDate(date);
//                        break;
//                }
//
//                if (sq != null && value != null) {
//                    listX.add(sq);
//                    listY.add(value);
//                }
//            }
//
//            ArrayList<Entry> entries = new ArrayList<>();
//            float sumX = 0;
//            float sumY = 0;
//            float sumXX = 0;
//            float sumYY = 0;
//            float sumXY = 0;
//            int count = 0;
//            ArrayList<String> xAxis = new ArrayList<>();
//
//            if (listY.size() > 0) {
//                for (int i = 0; i < listX.size(); i++) {
//                    sumX += Float.parseFloat(listX.get(i));
//                    sumY += Float.parseFloat(listY.get(i));
//                    count++;
//                }
//
//                float meanX = sumX / count;
//                float meanY = sumY / count;
//
//                for (int i = 0; i < listX.size(); i++) {
//                    sumXX += (Float.parseFloat(listX.get(i)) - meanX) * (Float.parseFloat(listX.get(i)) - meanX);
//                    sumYY += (Float.parseFloat(listY.get(i)) - meanY) * (Float.parseFloat(listY.get(i)) - meanY);
//                    sumXY += (Float.parseFloat(listX.get(i)) - meanX) * (Float.parseFloat(listY.get(i)) - meanY);
//                }
//
//
//                float k = sumXY / sumXX;
//                float n = meanY - k * meanX;
//
////                Map<String, String> map= new HashMap<>();
////                for (int i = 0; i< listX.size(); i++){
////                    map.put(listX.get(i), listY.get(i));
////                }
////
////                SortedSet<String> keys = new TreeSet<String>(map.keySet());
////                ArrayList<Entry> scatterEntry = new ArrayList<>();
////                for(String key: keys) {
////                    scatterEntry.add(new Entry(Float.parseFloat(map.get(key)),Integer.parseInt(key)));
////                }
////                ScatterDataSet set1 = new ScatterDataSet(scatterEntry, tp.corelation);
////
////                ArrayList<ScatterDataSet> dataSets = new ArrayList<ScatterDataSet>();
////                dataSets.add(set1);
////
////                ScatterData data = new ScatterData(dataSets);
////                scatterChart.setData(data);
//
//                for (int i = 0; i < 10; i++) {
//                    entries.add(new Entry(k * i + n, i));
//                    xAxis.add(Integer.toString(i));
//                }
//
//               //koristi ovo za Tab 3 BarDataSet dataset = new BarDataSet(entries, "First");
////                ArrayList<BarEntry> entries = new ArrayList<>();
//
//
//                LineDataSet dataSet = new LineDataSet(entries, tp.corelation);
//                dataSet.setCircleColor(Color.argb(0, 1, 0, 0));
//                dataSet.setColor(Color.BLUE);
//                dataSet.setDrawValues(false);
//                dataSet.setDrawCircles(false);
//               // dataSet.setDrawFilled(true);
//                LineData data = new LineData(xAxis, dataSet);
//                lineChart.setGridBackgroundColor(Color.argb(50, 1, 0, 0));
//                lineChart.setData(data);
//                lineChart.animateY(5000);
//
//            }
        //  }

        //   return view;

        //   }

        return view;
    }
}
