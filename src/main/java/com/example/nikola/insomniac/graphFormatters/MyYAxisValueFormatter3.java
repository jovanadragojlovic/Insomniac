package com.example.nikola.insomniac.graphFormatters;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;


public class MyYAxisValueFormatter3 implements YAxisValueFormatter {

    private DecimalFormat mFormat;

    public MyYAxisValueFormatter3 () {
        mFormat = new DecimalFormat("###,###,##0"); // use one decimal
    }

    @Override
    public String getFormattedValue(float value, YAxis yAxis) {
        long minutes = (long) value;

        long hours = TimeUnit.MINUTES.toHours(minutes);

        return hours + "h ";
    }
}