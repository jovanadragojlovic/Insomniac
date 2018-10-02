package com.example.nikola.insomniac.graphFormatters;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

public class MyValueFormatter2 implements ValueFormatter {

    private DecimalFormat mFormat;

    public MyValueFormatter2() {
        mFormat = new DecimalFormat("###,###,##0.0"); // use one decimal
    }

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return makePretty(value);
    }

    private String makePretty(float value) {

        long temporaryminutes = (long) value;
        long hours = temporaryminutes/60;

        return hours + "h ";
    }
}
