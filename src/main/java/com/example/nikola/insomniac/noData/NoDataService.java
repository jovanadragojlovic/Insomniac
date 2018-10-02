package com.example.nikola.insomniac.noData;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.nikola.insomniac.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NoDataService extends IntentService {

    public String prazan = "0";
    private static final String TAG = "SleepQuality";
    final Context context = this;
    DatabaseHelper mDatabaseHelper;


    public NoDataService() {
        super("NoDataService");
    }

    @Override
    public void onHandleIntent(Intent intent) {

        Log.d(TAG, "nodata");
        mDatabaseHelper = new DatabaseHelper(context);
        String dateYesterday = new SimpleDateFormat("MM/dd/yy").format(yesterday());

        if (mDatabaseHelper.getDailyLightByDate(dateYesterday) == null) {
            mDatabaseHelper.addDailyLightData(prazan, dateYesterday);
        }

        if (mDatabaseHelper.getNightlyLightByDate(dateYesterday) == null) {
            mDatabaseHelper.addNightlyLightData(prazan, dateYesterday);
        }

        if (mDatabaseHelper.getSportByDate(dateYesterday) == null) {
            mDatabaseHelper.addPhysicalActivitySport(prazan, dateYesterday);
        }

        if (mDatabaseHelper.getCoffeeByDate(dateYesterday) == null) {
            mDatabaseHelper.addCoffeeData(prazan, dateYesterday);
        }

        if (mDatabaseHelper.getHumidityByDate(dateYesterday) == null) {
            mDatabaseHelper.addBedroomHumidity(prazan, dateYesterday);
        }

        if (mDatabaseHelper.getSleepingTimeByDate(dateYesterday) == null) {
            mDatabaseHelper.addSleepingTime(prazan, dateYesterday);
        }

        if (mDatabaseHelper.getSleepQualityByDate(dateYesterday) == null) {
            mDatabaseHelper.addSleepQualityData(prazan, dateYesterday);
        }
    }


    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

//    private Date dayBeforeYesterday() {
//        final Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, -2);
//        return cal.getTime();
//    }
}
