package com.example.nikola.insomniac.statistics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collection;

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

        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

//        if(tp.arrayList.size() > 0){
//            Log.d(TAG,"arrayList" + tp.arrayList);
//       for(int i = 0; i <  tp.arrayList.size(); i++ ) {
//
//        values = databaseHelper.getDataValues(tp.arrayList.get(i), );
//           Log.d(TAG,"values" + values);
//           for (int j = 0; values.size() > j; j++) {
//               Log.d(TAG,"valueeeeeeeeee" + values.get(j));
//               entries.add(new Entry(Float.parseFloat( values.get(j)), j));
//           }
//       }
//        }else {
//            entries.add(new Entry(0f, 0));
//        }
        Log.d(TAG,"entries" + entries);
        entries.add(new Entry(4f, 2));
        entries.add(new Entry(8f, 3));
        entries.add(new Entry(6f, 4));
        entries.add(new Entry(2f, 5));
        entries.add(new Entry(5f, 0));
        entries.add(new Entry(10f, 1));

        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        LineData data = new LineData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);

        lineChart.setData(data);
        lineChart.animateY(5000);


        return view;



    }

}
