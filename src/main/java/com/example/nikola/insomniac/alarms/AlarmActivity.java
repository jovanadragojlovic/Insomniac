package com.example.nikola.insomniac.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.example.nikola.insomniac.PreferencesHelper;
import com.example.nikola.insomniac.R;
import com.example.nikola.insomniac.Reminders;

import java.util.Calendar;

import static android.R.attr.timeZone;


public class AlarmActivity extends Reminders {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker timePicker1;
    private static AlarmActivity inst;

    public static AlarmActivity instance() {
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
        setContentView(R.layout.alarmactivity);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        ToggleButton alarmToggle = (ToggleButton) findViewById(R.id.alarmToggle);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        preferencesHelper = new PreferencesHelper(getApplicationContext());
        alarmToggle.setChecked( preferencesHelper.loadBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE) );

        SharedPreferences prefs = getPreferences(MODE_PRIVATE); timePicker1.setCurrentHour(prefs.getInt("hour", 1)); timePicker1.setCurrentMinute(prefs.getInt("minute", 01));

    }

    public void onToggleClicked(View view) {
        if (((Switch) view).isChecked()) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, timePicker1.getCurrentHour());
            calendar.set(Calendar.MINUTE, timePicker1.getCurrentMinute());
            calendar.set(Calendar.AM_PM, timeZone);
            Intent myIntent = new Intent(AlarmActivity.this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 0, myIntent, 0);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, pendingIntent);




            preferencesHelper.saveBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE, true);

            SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
            editor.putInt("hour", timePicker1.getCurrentHour());
            editor.putInt("minute", timePicker1.getCurrentMinute()); 
            editor.commit();

        } else {
            alarmManager.cancel(pendingIntent);

            preferencesHelper.saveBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE, false);


        }
    }



}