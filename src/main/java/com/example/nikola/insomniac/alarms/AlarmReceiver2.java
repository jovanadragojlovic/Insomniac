package com.example.nikola.insomniac.alarms;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class AlarmReceiver2 extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {



        //this will send a notification message
        ComponentName comp = new ComponentName(context.getPackageName(),
                AlarmService2.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }
}