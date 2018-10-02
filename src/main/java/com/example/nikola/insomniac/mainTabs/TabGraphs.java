package com.example.nikola.insomniac.mainTabs;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.R;
import com.example.nikola.insomniac.graphFormatters.MyValueFormatter;
import com.example.nikola.insomniac.graphFormatters.MyYAxisValueFormatter;
import com.example.nikola.insomniac.graphFormatters.MyYAxisValueFormatter2;
import com.example.nikola.insomniac.graphFormatters.MyYAxisValueFormatter3;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static com.example.nikola.insomniac.R.id.chart1;
import static com.example.nikola.insomniac.R.id.chart2;
import static com.example.nikola.insomniac.R.id.chart3;
import static com.example.nikola.insomniac.R.id.chart4;
import static com.example.nikola.insomniac.R.id.chart5;
import static com.example.nikola.insomniac.R.id.chart6;
import static com.example.nikola.insomniac.R.id.chart7;

public class TabGraphs extends Fragment {
    DatabaseHelper databaseHelper;
    ArrayList<String> variablaList = new ArrayList<String>();

    private static final String TAG = "SleepQuality";
    final String PREFS_NAME = "MyPrefsFile2";
    int position;

    BarChart barChart1;
    BarChart barChart2;
    BarChart barChart3;
    BarChart barChart4;
    BarChart barChart5;
    BarChart barChart6;
    BarChart barChart7;

    public String clickedVar1;
    public String clickedVar2;
    public String clickedVar3;
    public String clickedVar4;
    public String clickedVar5;
    public String clickedVar6;
    public String clickedVar7;

    double sum1 = 0;
    double sum2 = 0;
    double sum3 = 0;
    double sum4 = 0;
    double sum5 = 0;
    double sum6 = 0;
    double sum7 = 0;
    double average1 = 0;
    double average2 = 0;
    double average3 = 0;
    double average4 = 0;
    double average5 = 0;
    double average6 = 0;
    double average7 = 0;

    TextView aVerage1;
    TextView aVerage2;
    TextView aVerage3;
    TextView aVerage4;
    TextView aVerage5;
    TextView aVerage6;
    TextView aVerage7;

    Spinner spinner_graph1;
    Spinner spinner_graph2;
    Spinner spinner_graph3;
    Spinner spinner_graph4;
    Spinner spinner_graph5;
    Spinner spinner_graph6;
    Spinner spinner_graph7;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_graphs, container, false);

        databaseHelper = new DatabaseHelper(getActivity());

        barChart1 = (BarChart) view.findViewById(chart1);
        barChart2 = (BarChart) view.findViewById(chart2);
        barChart3 = (BarChart) view.findViewById(chart3);
        barChart4 = (BarChart) view.findViewById(chart4);
        barChart5 = (BarChart) view.findViewById(chart5);
        barChart6 = (BarChart) view.findViewById(chart6);
        barChart7 = (BarChart) view.findViewById(chart7);

        aVerage1 = (TextView)view.findViewById(R.id.average1);
        aVerage2 = (TextView)view.findViewById(R.id.average2);
        aVerage3 = (TextView)view.findViewById(R.id.average3);
        aVerage4 = (TextView)view.findViewById(R.id.average4);
        aVerage5 = (TextView)view.findViewById(R.id.average5);
        aVerage6 = (TextView)view.findViewById(R.id.average6);
        aVerage7 = (TextView)view.findViewById(R.id.average7);

        spinner_graph1 = (Spinner) view.findViewById(R.id.spinner_graph1);
        spinner_graph2 = (Spinner) view.findViewById(R.id.spinner_graph2);
        spinner_graph3 = (Spinner) view.findViewById(R.id.spinner_graph3);
        spinner_graph4 = (Spinner) view.findViewById(R.id.spinner_graph4);
        spinner_graph5 = (Spinner) view.findViewById(R.id.spinner_graph5);
        spinner_graph6 = (Spinner) view.findViewById(R.id.spinner_graph6);
        spinner_graph7 = (Spinner) view.findViewById(R.id.spinner_graph7);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_graphs, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_graph1.setAdapter(adapter);
        spinner_graph2.setAdapter(adapter);
        spinner_graph3.setAdapter(adapter);
        spinner_graph4.setAdapter(adapter);
        spinner_graph5.setAdapter(adapter);
        spinner_graph6.setAdapter(adapter);
        spinner_graph7.setAdapter(adapter);






        ArrayList<String> variables1 = new ArrayList<String>() {{add("SleepQuality");add("DailyLight");add("NightlyLight");add("PhysicalActivity");add("SleepingTime");add("Coffee");add("Bedroom");
        }};
        ArrayList<String> columns1 = new ArrayList<String>() {{add("SleepQuality");add("AverageLux");add("AverageLux");add("Sport");add("SleepingTimeAmount");add("CoffeeAmount");add("Humidity");
        }};

        Integer graphSize1 = 0;

        Integer columnIndex1 = variables1.indexOf("SleepQuality");
        ArrayList<String> values1 = databaseHelper.getDataValues("SleepQuality", columns1.get(columnIndex1));
        final ArrayList<String> dates1 = databaseHelper.getDataValues("SleepQuality", "Date");

        double counterVecihOdNula1 = 0;
        double temporaryValue1 = 0;

        ArrayList<BarEntry> entries1 = new ArrayList<>();
        if (values1.size() > 0) {
            for (int j = 0; j < values1.size(); j++) {
                entries1.add(new BarEntry(Integer.parseInt(values1.get(j)), j));

                temporaryValue1 = Double.parseDouble(values1.get(j));

                if (temporaryValue1 > 0){
                    counterVecihOdNula1++;
                    sum1 += temporaryValue1;
                }
            }

            average1 = sum1/counterVecihOdNula1;
            String AVERAGE1 = String.format(Locale.getDefault(),"%.2f", average1);
            aVerage1.setText("Average: " + AVERAGE1);


            if (entries1.size() > graphSize1) {
                graphSize1 = entries1.size();
            }


            BarDataSet dataSet = new BarDataSet(entries1, "Sleep quality");
            dataSet.setValueTextColor(Color.BLACK);
            dataSet.setBarSpacePercent(80f);
            dataSet.setValueTextSize(13f);
            dataSet.setColor(Color.YELLOW);
            dataSet.setDrawValues(false);


            ArrayList<String> xAxis1 = new ArrayList<>();
            for (int k = 0; k < graphSize1; k++) {
                xAxis1.add(dates1.get(k));
            }

            barChart1.setData(new BarData(xAxis1, dataSet));

            barChart1.getXAxis().setTextColor(Color.BLACK);
            barChart1.getAxisRight().setTextColor(Color.BLACK);
            barChart1.getAxisLeft().setTextColor(Color.BLACK);
            barChart1.setDescriptionColor(Color.BLACK);
            barChart1.getLegend().setTextColor(Color.BLACK);
            barChart1.setBorderColor(Color.BLACK);

            barChart1.setVisibleXRange(1, 5);
            barChart1.setDescription("");
            barChart1.setDrawGridBackground(true);
            barChart1.setDrawBorders(false);
            barChart1.setGridBackgroundColor(Color.WHITE);

            barChart1.getLegend().setEnabled(false);

            barChart1.getAxisRight().setDrawGridLines(false);
            barChart1.getAxisRight().setDrawLabels(false);
            barChart1.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            barChart1.getXAxis().setDrawGridLines(false);

            barChart1.getAxisLeft().setDrawGridLines(true);
            barChart1.getAxisLeft().setDrawLabels(true);
            barChart1.getAxisLeft().setLabelCount(6, true);
            barChart1.getAxisLeft().setAxisMaxValue(5);
            barChart1.getAxisLeft().setValueFormatter(new MyYAxisValueFormatter());

            barChart1.moveViewToX(9999);
            barChart1.zoomOut();
            barChart1.setTouchEnabled(false);

            barChart1.invalidate();

        }
        ;



        ArrayList<String> variables2 = new ArrayList<String>() {{add("SleepQuality");add("DailyLight");add("NightlyLight");add("PhysicalActivity");add("SleepingTime");add("Coffee");add("Bedroom");
        }};
        ArrayList<String> columns2 = new ArrayList<String>() {{add("SleepQuality");add("AverageLux");add("AverageLux");add("Sport");add("SleepingTimeAmount");add("CoffeeAmount");add("Humidity");
        }};

        Integer graphSize2 = 0;


        Integer columnIndex2 = variables1.indexOf("SleepingTime");
        ArrayList<String> values2 = databaseHelper.getDataValues("SleepingTime", columns2.get(columnIndex2));
        final ArrayList<String> dates2 = databaseHelper.getDataValues("SleepingTime", "Date");


        double counterVecihOdNula2 = 0;
        double temporaryValue2 = 0;

        ArrayList<BarEntry> entries2 = new ArrayList<>();
        ArrayList<IBarDataSet> bars2 = new ArrayList<>();
        if (values2.size() > 0) {
            for (int j = 0; j < values2.size(); j++) {

                entries2.add(new BarEntry( Integer.parseInt(values2.get(j)), j));

                temporaryValue2 = Double.parseDouble(values2.get(j));

                if (temporaryValue2 > 0){
                    counterVecihOdNula2++;
                    sum2 += temporaryValue2;
                }
            }
            if (entries2.size() > graphSize2) {
                graphSize2 = entries2.size();
            }

            average2 = (sum2/counterVecihOdNula2);
            long minutes = (long) average2;

            long hours = TimeUnit.MINUTES.toHours(minutes);

            minutes -= TimeUnit.HOURS.toMinutes(hours);

            aVerage2.setText("Average: " + String.valueOf(hours) + " h " + String.valueOf(minutes) + " m ");


            BarDataSet dataSet = new BarDataSet(entries2, "Sleep duration");
            dataSet.setValueFormatter(new MyValueFormatter());
            dataSet.setValueTextColor(Color.BLACK);
            dataSet.setBarSpacePercent(80f);
            dataSet.setValueTextSize(13f);
            dataSet.setColor(Color.GREEN);
            dataSet.setDrawValues(false);



            ArrayList<String> xAxis2 = new ArrayList<>();
            for (int k = 0; k < graphSize2; k++) {
                xAxis2.add(dates2.get(k));
            }

            barChart2.setData(new BarData(xAxis2, dataSet));

            barChart2.getXAxis().setTextColor(Color.BLACK);
            barChart2.getAxisRight().setTextColor(Color.BLACK);
            barChart2.getAxisLeft().setTextColor(Color.BLACK);
            barChart2.setDescriptionColor(Color.BLACK);
            barChart2.getLegend().setTextColor(Color.BLACK);
            barChart2.setBorderColor(Color.BLACK);

            barChart2.setVisibleXRange(1, 5);
            barChart2.setDescription("");
            barChart2.setDrawGridBackground(true);
            barChart2.setDrawBorders(false);
            barChart2.setGridBackgroundColor(Color.WHITE);

            barChart2.getLegend().setEnabled(false);

            barChart2.getAxisRight().setDrawGridLines(false);
            barChart2.getAxisRight().setDrawLabels(false);
            barChart2.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            barChart2.getXAxis().setDrawGridLines(false);

            barChart2.getAxisLeft().setDrawGridLines(true);
            barChart2.getAxisLeft().setDrawLabels(true);
            barChart2.getAxisLeft().setLabelCount(11, true);
            barChart2.getAxisLeft().setAxisMaxValue(600);
            barChart2.getAxisLeft().setValueFormatter(new MyYAxisValueFormatter3());

            barChart2.moveViewToX(9999);
            barChart2.zoomOut();
            barChart2.setTouchEnabled(false);

            barChart2.invalidate();

        }



        ArrayList<String> variables3 = new ArrayList<String>() {{add("SleepQuality");add("DailyLight");add("NightlyLight");add("PhysicalActivity");add("SleepingTime");add("Coffee");add("Bedroom");
        }};
        ArrayList<String> columns3 = new ArrayList<String>() {{add("SleepQuality");add("AverageLux");add("AverageLux");add("Sport");add("sleepingTimeAmount");add("CoffeeAmount");add("Humidity");
        }};


        Integer graphSize3 = 0;


        Integer columnIndex3 = variables3.indexOf("PhysicalActivity");
        ArrayList<String> values3 = databaseHelper.getDataValues("PhysicalActivity", columns3.get(columnIndex3));
                        /* ArrayList<String> values2 = databaseHelper.getDataValues(clickedVar, "Steps"); */
        final ArrayList<String> dates3 = databaseHelper.getDataValues("PhysicalActivity", "Date");

                         /* ArrayList<IBarDataSet> bars = new ArrayList<>(); */


        double counterVecihOdNula3 = 0;
        double temporaryValue3 = 0;

        ArrayList<BarEntry> entries3 = new ArrayList<>();
        if (values3.size() > 0) {
            for (int j = 0; j < values3.size(); j++) {
                Double value3 = Double.parseDouble(values3.get(j));
                entries3.add(new BarEntry((int) Math.round(value3), j));

                temporaryValue3 = Double.parseDouble(values3.get(j));

                if (temporaryValue3 > 0){
                    counterVecihOdNula3++;
                    sum3 += temporaryValue3;
                }
            }

            average3 = (sum3/counterVecihOdNula3);
            long seconds = (long) average3;
            long hours = TimeUnit.SECONDS.toHours(seconds);
            seconds -= TimeUnit.HOURS.toSeconds(hours);
            long minutes = TimeUnit.SECONDS.toMinutes(seconds);
            aVerage3.setText("Average: " + String.valueOf(hours) + " h " + String.valueOf(minutes) + " m ");


            if (entries3.size() > graphSize3) {
                graphSize3 = entries3.size();
            }

            BarDataSet dataSet = new BarDataSet(entries3, "Physical activity");
            dataSet.setValueTextColor(Color.BLACK);
            dataSet.setBarSpacePercent(80f);
            dataSet.setValueTextSize(12f);
            dataSet.setValueFormatter(new MyValueFormatter());
            dataSet.setColor(Color.RED);
            dataSet.setDrawValues(false);


                            /*
                            ArrayList<BarEntry> entries2 = new ArrayList<>();
                            if(values2.size() > 0) {
                                for (int j = 0; j < values2.size(); j++) {
                                    entries2.add(new BarEntry(Integer.parseInt(values2.get(j)), j));
                                }
                                if (entries2.size() > graphSize) {
                                    graphSize = entries2.size();
                                }

                                BarDataSet dataSet2 = new BarDataSet(entries2, "Steps");
                                dataSet2.setColor(Color.CYAN);
                                dataSet2.setValueTextColor(Color.BLACK);
                                dataSet2.setBarSpacePercent(90f);
                                dataSet2.setValueTextSize(15f);

                                  bars.add(dataSet2);
                            } */

                           /* bars.add(dataSet); */


            ArrayList<String> xAxis3 = new ArrayList<>();
            for (int k = 0; k < graphSize3; k++) {
                xAxis3.add(dates3.get(k));
            }

            barChart3.setData(new BarData(xAxis3, dataSet)); /* was bars */

            barChart3.getXAxis().setTextColor(Color.BLACK);
            barChart3.getAxisRight().setTextColor(Color.BLACK);
            barChart3.getAxisLeft().setTextColor(Color.BLACK);
            barChart3.setDescriptionColor(Color.BLACK);
            barChart3.getLegend().setTextColor(Color.BLACK);
            barChart3.setBorderColor(Color.BLACK);

            barChart3.setVisibleXRange(1, 5);
            barChart3.setDescription("");
            barChart3.setDrawGridBackground(true);
            barChart3.setDrawBorders(false);
            barChart3.setGridBackgroundColor(Color.WHITE);

            barChart3.getLegend().setEnabled(false);

            barChart3.getAxisRight().setDrawGridLines(false);
            barChart3.getAxisRight().setDrawLabels(false);
            barChart3.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            barChart3.getXAxis().setDrawGridLines(false);

            barChart3.getAxisLeft().setDrawGridLines(true);
            barChart3.getAxisLeft().setDrawLabels(true);
            barChart3.getAxisLeft().setLabelCount(4, true);
            barChart3.getAxisLeft().setAxisMaxValue(10800);
            barChart3.getAxisLeft().setValueFormatter(new MyYAxisValueFormatter2());

            barChart3.moveViewToX(9999);
            barChart3.zoomOut();
            barChart3.setTouchEnabled(false);


            barChart3.invalidate();
        }



        ArrayList<String> variables4 = new ArrayList<String>() {{add("SleepQuality");add("DailyLight");add("NightlyLight");add("PhysicalActivity");add("SleepingTime");add("Coffee");add("Bedroom");
        }};
        ArrayList<String> columns4 = new ArrayList<String>() {{add("SleepQuality");add("AverageLux");add("AverageLux");add("Sport");add("SleepingTimeAmount");add("CoffeeAmount");add("Humidity");
        }};

        Integer graphSize4 = 0;


        Integer columnIndex4 = variables4.indexOf("DailyLight");
        ArrayList<String> values4 = databaseHelper.getDataValues("DailyLight", columns4.get(columnIndex4));
        final ArrayList<String> dates4 = databaseHelper.getDataValues("DailyLight", "Date");

        double counterVecihOdNula4 = 0;
        double temporaryValue4 = 0;

        ArrayList<BarEntry> entries4 = new ArrayList<>();
        if (values4.size() > 0) {
            for (int j = 0; j < values4.size(); j++) {
                Double value = Double.parseDouble(values4.get(j));
                entries4.add(new BarEntry((int) Math.round(value), j));


                temporaryValue4 = Double.parseDouble(values4.get(j));

                if (temporaryValue4 > 0){
                    counterVecihOdNula4++;
                    sum4 += temporaryValue4;
                }
            }

            average4 = (sum4/counterVecihOdNula4);
            long seconds = (long) average4;
            long hours = TimeUnit.SECONDS.toHours(seconds);
            seconds -= TimeUnit.HOURS.toSeconds(hours);
            long minutes = TimeUnit.SECONDS.toMinutes(seconds);
            aVerage4.setText("Average: " + String.valueOf(hours) + " h " + String.valueOf(minutes) + " m ");


            if (entries4.size() > graphSize4) {
                graphSize4 = entries4.size();
            }

            BarDataSet dataSet = new BarDataSet(entries4, "Daily light");
            dataSet.setValueTextColor(Color.BLACK);
            dataSet.setBarSpacePercent(80f);
            dataSet.setValueTextSize(12f);
            dataSet.setDrawValues(false);
            dataSet.setColor(Color.YELLOW);
            dataSet.setValueFormatter(new MyValueFormatter());

            ArrayList<String> xAxis4 = new ArrayList<>();
            for (int k = 0; k < graphSize4; k++) {
                xAxis4.add(dates4.get(k));
            }

            barChart4.setData(new BarData(xAxis4, dataSet));

            barChart4.getXAxis().setTextColor(Color.BLACK);
            barChart4.getAxisRight().setTextColor(Color.BLACK);
            barChart4.getAxisLeft().setTextColor(Color.BLACK);
            barChart4.setDescriptionColor(Color.BLACK);
            barChart4.getLegend().setTextColor(Color.BLACK);
            barChart4.setBorderColor(Color.BLACK);

            barChart4.setVisibleXRange(1, 5);
            barChart4.setDrawGridBackground(true);
            barChart4.setDrawBorders(false);
            barChart4.setDescription("");
            barChart4.setGridBackgroundColor(Color.WHITE);

            barChart4.getLegend().setEnabled(false);

            barChart4.getAxisRight().setDrawGridLines(false);
            barChart4.getAxisRight().setDrawLabels(false);
            barChart4.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            barChart4.getXAxis().setDrawGridLines(false);

            barChart4.getAxisLeft().setDrawGridLines(true);
            barChart4.getAxisLeft().setDrawLabels(true);
            barChart4.getAxisLeft().setLabelCount(6, true);
            barChart4.getAxisLeft().setAxisMaxValue(18000);
            barChart4.getAxisLeft().setValueFormatter(new MyYAxisValueFormatter2());

            barChart4.moveViewToX(9999);
            barChart4.zoomOut();
            barChart4.setTouchEnabled(false);


            barChart4.invalidate();
        }



        ArrayList<String> variables5 = new ArrayList<String>() {{add("SleepQuality");add("DailyLight");add("NightlyLight");add("PhysicalActivity");add("SleepingTime");add("Coffee");add("Bedroom");
        }};
        ArrayList<String> columns5 = new ArrayList<String>() {{add("SleepQuality");add("AverageLux");add("AverageLux");add("Sport");add("SleepingTimeAmount");add("CoffeeAmount");add("Humidity");
        }};


        Integer graphSize5 = 0;


        Integer columnIndex5 = variables5.indexOf("NightlyLight");
        ArrayList<String> values5 = databaseHelper.getDataValues("NightlyLight", columns5.get(columnIndex5));
        final ArrayList<String> dates5 = databaseHelper.getDataValues("NightlyLight", "Date");


        double counterVecihOdNula5 = 0;
        double temporaryValue5 = 0;

        ArrayList<BarEntry> entries5 = new ArrayList<>();
        if (values5.size() > 0) {
            for (int j = 0; j < values5.size(); j++) {
                Double value = Double.parseDouble(values5.get(j));
                entries5.add(new BarEntry((int) Math.round(value), j));

                temporaryValue5 = Double.parseDouble(values5.get(j));

                if (temporaryValue5 > 0){
                    counterVecihOdNula5++;
                    sum5 += temporaryValue5;
                }
            }
            if (entries5.size() > graphSize5) {
                graphSize5 = entries5.size();
            }

            average5 = (sum5/counterVecihOdNula5);
            long seconds = (long) average5;
            long hours = TimeUnit.SECONDS.toHours(seconds);
            seconds -= TimeUnit.HOURS.toSeconds(hours);
            long minutes = TimeUnit.SECONDS.toMinutes(seconds);
            aVerage5.setText("Average: " + String.valueOf(hours) + " h " + String.valueOf(minutes) + " m ");


            BarDataSet dataSet = new BarDataSet(entries5, "Nightly light");
            dataSet.setValueTextColor(Color.BLACK);
            dataSet.setBarSpacePercent(80f);
            dataSet.setValueTextSize(12f);
            dataSet.setValueFormatter(new MyValueFormatter());
            dataSet.setColor(Color.GREEN);
            dataSet.setDrawValues(false);


            ArrayList<String> xAxis5 = new ArrayList<>();
            for (int k = 0; k < graphSize5; k++) {
                xAxis5.add(dates5.get(k));
            }

            barChart5.setData(new BarData(xAxis5, dataSet));

            barChart5.getXAxis().setTextColor(Color.BLACK);
            barChart5.getAxisRight().setTextColor(Color.BLACK);
            barChart5.getAxisLeft().setTextColor(Color.BLACK);
            barChart5.setDescriptionColor(Color.BLACK);
            barChart5.getLegend().setTextColor(Color.BLACK);
            barChart5.setBorderColor(Color.BLACK);

            barChart5.setVisibleXRange(1, 5);
            barChart5.setDescription("");
            barChart5.setDrawGridBackground(true);
            barChart5.setDrawBorders(false);
            barChart5.setGridBackgroundColor(Color.WHITE);

            barChart5.getLegend().setEnabled(false);


            barChart5.getAxisRight().setDrawGridLines(false);
            barChart5.getAxisRight().setDrawLabels(false);
            barChart5.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            barChart5.getXAxis().setDrawGridLines(false);

            barChart5.getAxisLeft().setDrawGridLines(true);
            barChart5.getAxisLeft().setDrawLabels(true);
            barChart5.getAxisLeft().setLabelCount(5, true);
            barChart5.getAxisLeft().setAxisMaxValue(14500);
            barChart5.getAxisLeft().setValueFormatter(new MyYAxisValueFormatter2());

            barChart5.moveViewToX(9999);
            barChart5.zoomOut();
            barChart5.setTouchEnabled(false);


            barChart5.invalidate();

        }



        ArrayList<String> variables6 = new ArrayList<String>() {{add("SleepQuality");add("DailyLight");add("NightlyLight");add("PhysicalActivity");add("SleepingTime");add("Coffee");add("Bedroom");
        }};
        ArrayList<String> columns6 = new ArrayList<String>() {{add("SleepQuality");add("AverageLux");add("AverageLux");add("Sport");add("SleepingTimeAmount");add("CoffeeAmount");add("Humidity");
        }};

        Integer graphSize6 = 0;

        Integer columnIndex6 = variables6.indexOf("Coffee");
        ArrayList<String> values6 = databaseHelper.getDataValues("Coffee", columns6.get(columnIndex6));
        final ArrayList<String> dates6 = databaseHelper.getDataValues("Coffee", "Date");

        double counterVecihOdNula6 = 0;
        double temporaryValue6 = 0;

        ArrayList<BarEntry> entries6 = new ArrayList<>();
        if (values6.size() > 0) {
            for (int j = 0; j < values6.size(); j++) {

                entries6.add(new BarEntry(Integer.parseInt(values6.get(j)), j));
                temporaryValue6 = Double.parseDouble(values6.get(j));

                if (temporaryValue6 > 0){
                    counterVecihOdNula6++;
                    sum6 += temporaryValue6;
                }
            }

            average6 = (sum6/counterVecihOdNula6);
            String AVERAGE6 = String.format(Locale.getDefault(),"%.2f", average6);
            aVerage6.setText("Average: " + AVERAGE6);

            if (entries6.size() > graphSize6) {
                graphSize6 = entries6.size();
            }

            BarDataSet dataSet = new BarDataSet(entries6, clickedVar6);
            dataSet.setValueTextColor(Color.BLACK);
            dataSet.setValueTextSize(12f);
            dataSet.setBarSpacePercent(80f);
            dataSet.setColor(Color.RED);
            dataSet.setDrawValues(false);

            ArrayList<String> xAxis6 = new ArrayList<>();
            for (int k = 0; k < graphSize6; k++) {
                xAxis6.add(dates6.get(k));
            }

            barChart6.setData(new BarData(xAxis6, dataSet));

            barChart6.getXAxis().setTextColor(Color.BLACK);
            barChart6.getAxisRight().setTextColor(Color.BLACK);
            barChart6.getAxisLeft().setTextColor(Color.BLACK);
            barChart6.setDescriptionColor(Color.BLACK);
            barChart6.getLegend().setTextColor(Color.BLACK);
            barChart6.setBorderColor(Color.BLACK);

            barChart6.setVisibleXRange(1, 5);
            barChart6.setDescription("");
            barChart6.setDrawGridBackground(true);
            barChart6.setDrawBorders(false);
            barChart6.setGridBackgroundColor(Color.WHITE);

            barChart6.getLegend().setEnabled(false);

            barChart6.getAxisRight().setDrawGridLines(false);
            barChart6.getAxisRight().setDrawLabels(false);
            barChart6.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            barChart6.getXAxis().setDrawGridLines(false);

            barChart6.getAxisLeft().setDrawGridLines(true);
            barChart6.getAxisLeft().setDrawLabels(true);
            barChart6.getAxisLeft().setLabelCount(4, true);
            barChart6.getAxisLeft().setAxisMaxValue(3);
            barChart6.getAxisLeft().setValueFormatter(new MyYAxisValueFormatter());

            barChart6.moveViewToX(9999);
            barChart6.zoomOut();
            barChart6.setTouchEnabled(false);


            barChart6.invalidate();

        }


        ArrayList<String> variables7 = new ArrayList<String>() {{add("SleepQuality");add("DailyLight");add("NightlyLight");add("PhysicalActivity");add("SleepingTime");add("Coffee");add("Bedroom");
        }};
        ArrayList<String> columns7 = new ArrayList<String>() {{add("SleepQuality");add("AverageLux");add("AverageLux");add("Sport");add("SleepingTimeAmount");add("CoffeeAmount");add("Humidity");
        }};

        Integer graphSize7 = 0;

        Integer columnIndex7 = variables7.indexOf("Bedroom");
        ArrayList<String> values7 = databaseHelper.getDataValues("Bedroom", columns7.get(columnIndex7));
        final ArrayList<String> dates7 = databaseHelper.getDataValues("Bedroom", "Date");

        double counterVecihOdNula7 = 0;
        double temporaryValue7 = 0;

        ArrayList<BarEntry> entries7 = new ArrayList<>();
        if (values7.size() > 0) {
            for (int j = 0; j < values7.size(); j++) {
                entries7.add(new BarEntry(Integer.parseInt(values7.get(j)), j));

                temporaryValue7 = Double.parseDouble(values7.get(j));

                if (temporaryValue7 > 0){
                    counterVecihOdNula7++;
                    sum7 += temporaryValue7;
                }
            }

            average7 = (sum7/counterVecihOdNula7);
            String AVERAGE7 = String.format(Locale.getDefault(),"%.2f", average7);
            aVerage7.setText("Average: " + AVERAGE7);

            if (entries7.size() > graphSize7) {
                graphSize7 = entries7.size();
            }

            BarDataSet dataSet = new BarDataSet(entries7, clickedVar7);
            dataSet.setValueTextColor(Color.BLACK);
            dataSet.setBarSpacePercent(80f);
            dataSet.setValueTextSize(12f);
            dataSet.setColor(Color.MAGENTA);
            dataSet.setDrawValues(false);

            ArrayList<String> xAxis7 = new ArrayList<>();
            for (int k = 0; k < graphSize7; k++) {
                xAxis7.add(dates7.get(k));
            }

            barChart7.setData(new BarData(xAxis7, dataSet));

            barChart7.getXAxis().setTextColor(Color.BLACK);
            barChart7.getAxisRight().setTextColor(Color.BLACK);
            barChart7.getAxisLeft().setTextColor(Color.BLACK);
            barChart7.setDescriptionColor(Color.BLACK);
            barChart7.getLegend().setTextColor(Color.BLACK);
            barChart7.setBorderColor(Color.BLACK);

            barChart7.setVisibleXRange(1, 5);
            barChart7.setDescription("");
            barChart7.setDrawGridBackground(true);
            barChart7.setDrawBorders(false);
            barChart7.setGridBackgroundColor(Color.WHITE);

            barChart7.getLegend().setEnabled(false);

            barChart7.getAxisRight().setDrawGridLines(false);
            barChart7.getAxisRight().setDrawLabels(false);
            barChart7.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            barChart7.getXAxis().setDrawGridLines(false);

            barChart7.getAxisLeft().setDrawGridLines(true);
            barChart7.getAxisLeft().setDrawLabels(true);
            barChart7.getAxisLeft().setLabelCount(6, true);
            barChart7.getAxisLeft().setAxisMaxValue(5);
            barChart7.getAxisLeft().setValueFormatter(new MyYAxisValueFormatter());

            barChart7.moveViewToX(9999);
            barChart7.zoomOut();
            barChart7.setTouchEnabled(false);

            barChart7.invalidate();
        }

        return view;
    }


        @Override
        public void setUserVisibleHint(boolean isVisibleToUser) {
            super.setUserVisibleHint(isVisibleToUser);
            if (isVisibleToUser) {
                sum1 = 0;
                sum2 = 0;
                sum3 = 0;
                sum4 = 0;
                sum5 = 0;
                sum6 = 0;
                sum7 = 0;
                getFragmentManager().beginTransaction().detach(this).attach(this).commit();
            }
    }
}
