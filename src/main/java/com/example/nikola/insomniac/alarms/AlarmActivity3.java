package com.example.nikola.insomniac.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.example.nikola.insomniac.PreferencesHelper;
import com.example.nikola.insomniac.R;
import com.example.nikola.insomniac.Reminders;

import java.util.Calendar;

import static android.R.attr.timeZone;


public class AlarmActivity3 extends Reminders {

    AlarmManager alarmManager3;
    private PendingIntent pendingIntent3;
    private TimePicker timePicker3;
    private static AlarmActivity3 inst;
    private TextView alarmTextView3;


    public static AlarmActivity3 instance() {
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
        setContentView(R.layout.alarmactivity3);
        timePicker3 = (TimePicker) findViewById(R.id.timePicker3);
        ToggleButton alarmToggle3 = (ToggleButton) findViewById(R.id.alarmToggle3);
        alarmManager3 = (AlarmManager) getSystemService(ALARM_SERVICE);

        preferencesHelper = new PreferencesHelper(getApplicationContext());
        alarmToggle3.setChecked( preferencesHelper.loadBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE_3) );

        SharedPreferences prefs = getPreferences(MODE_PRIVATE); timePicker3.setCurrentHour(prefs.getInt("hour", 1)); timePicker3.setCurrentMinute(prefs.getInt("minute", 01));


    }



    public void onToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, timePicker3.getCurrentHour());
            calendar.set(Calendar.MINUTE, timePicker3.getCurrentMinute());
            calendar.set(Calendar.AM_PM, timeZone);

            Intent myIntent = new Intent(AlarmActivity3.this, AlarmReceiver3.class);
            pendingIntent3 = PendingIntent.getBroadcast(AlarmActivity3.this, 0, myIntent, 0);
            alarmManager3.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, pendingIntent3);


            preferencesHelper.saveBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE_3, true);

            SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit(); editor.putInt("hour", timePicker3.getCurrentHour()); editor.putInt("minute", timePicker3.getCurrentMinute()); editor.commit();


        } else {
            alarmManager3.cancel(pendingIntent3);

            preferencesHelper.saveBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE_3, false);

        }
    }
}