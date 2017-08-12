package com.example.nikola.insomniac.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.example.nikola.insomniac.PreferencesHelper;
import com.example.nikola.insomniac.R;
import com.example.nikola.insomniac.Reminders;

import java.util.Calendar;

import static android.R.attr.timeZone;


public class AlarmActivity4 extends Reminders {

    AlarmManager alarmManager4;
    private PendingIntent pendingIntent4;
    private TimePicker timePicker4;
    private static AlarmActivity4 inst;


    public static AlarmActivity4 instance() {
        return inst;
    }

    private PreferencesHelper preferencesHelper;


    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarmactivity4);
        timePicker4 = (TimePicker) findViewById(R.id.timePicker4);
        ToggleButton alarmToggle4 = (ToggleButton) findViewById(R.id.alarmToggle4);
        alarmManager4 = (AlarmManager) getSystemService(ALARM_SERVICE);

        preferencesHelper = new PreferencesHelper(getApplicationContext());
        alarmToggle4.setChecked( preferencesHelper.loadBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE_4) );

        SharedPreferences prefs = getPreferences(MODE_PRIVATE); timePicker4.setCurrentHour(prefs.getInt("hour", 1)); timePicker4.setCurrentMinute(prefs.getInt("minute", 01));


    }



    public void onToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, timePicker4.getCurrentHour());
            calendar.set(Calendar.MINUTE, timePicker4.getCurrentMinute());
            calendar.set(Calendar.AM_PM, timeZone);

            Intent myIntent = new Intent(AlarmActivity4.this, AlarmReceiver4.class);
            pendingIntent4 = PendingIntent.getBroadcast(AlarmActivity4.this, 0, myIntent, 0);
            alarmManager4.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, pendingIntent4);

            preferencesHelper.saveBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE_4, true);

            SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit(); editor.putInt("hour", timePicker4.getCurrentHour()); editor.putInt("minute", timePicker4.getCurrentMinute()); editor.commit();


        } else {
            alarmManager4.cancel(pendingIntent4);
            preferencesHelper.saveBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE_4, false);

        }
    }

}