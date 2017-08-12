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


public class AlarmActivity2 extends Reminders {

    AlarmManager alarmManager2;
    private PendingIntent pendingIntent2;
    private TimePicker timePicker2;
    private static AlarmActivity2 inst;



    public static AlarmActivity2 instance() {
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
        setContentView(R.layout.alarmactivity2);
        timePicker2 = (TimePicker) findViewById(R.id.timePicker2);
        ToggleButton alarmToggle2 = (ToggleButton) findViewById(R.id.alarmToggle2);
        alarmManager2 = (AlarmManager) getSystemService(ALARM_SERVICE);

        preferencesHelper = new PreferencesHelper(getApplicationContext());
        alarmToggle2.setChecked( preferencesHelper.loadBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE_2) );

        SharedPreferences prefs = getPreferences(MODE_PRIVATE); timePicker2.setCurrentHour(prefs.getInt("hour", 1)); timePicker2.setCurrentMinute(prefs.getInt("minute", 01));


    }



    public void onToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, timePicker2.getCurrentHour());
            calendar.set(Calendar.MINUTE, timePicker2.getCurrentMinute());
            calendar.set(Calendar.AM_PM, timeZone);

            Intent myIntent = new Intent(AlarmActivity2.this, AlarmReceiver2.class);
            pendingIntent2 = PendingIntent.getBroadcast(AlarmActivity2.this, 0, myIntent, 0);
            alarmManager2.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, pendingIntent2);

            preferencesHelper.saveBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE_2, true);
            SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit(); editor.putInt("hour", timePicker2.getCurrentHour()); editor.putInt("minute", timePicker2.getCurrentMinute()); editor.commit();




        } else {
            alarmManager2.cancel(pendingIntent2);
            preferencesHelper.saveBoolean( PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE_2, false);


        }
    }
}