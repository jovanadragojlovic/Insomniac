package com.example.nikola.insomniac.graphFormatters;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;


public class MyYAxisValueFormatter2 implements YAxisValueFormatter {

    private DecimalFormat mFormat;

    public MyYAxisValueFormatter2 () {
        mFormat = new DecimalFormat("###,###,##0.0"); // use one decimal
    }

    @Override
    public String getFormattedValue(float value, YAxis yAxis) {
        return makePretty(value);
    }

    private String makePretty(float value) {
        long seconds = (long) value;

        long hours = TimeUnit.SECONDS.toHours(seconds);

        return hours + "h ";
    }
}
