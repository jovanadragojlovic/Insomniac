package com.example.nikola.insomniac.noData;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class NoDataReceiver extends WakefulBroadcastReceiver {

    private static final String TAG = "SleepQuality";



    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "nodata");

        ComponentName comp = new ComponentName(context.getPackageName(),
                NoDataService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);

    }



}