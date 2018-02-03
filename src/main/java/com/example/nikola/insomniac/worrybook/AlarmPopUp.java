package com.example.nikola.insomniac.worrybook;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;

import com.example.nikola.insomniac.PreferencesHelper;
import com.example.nikola.insomniac.R;
import com.example.nikola.insomniac.alarms.AlarmReceiver;

import java.util.Calendar;
import java.util.Date;

public class AlarmPopUp extends Activity {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker timePicker1;
    private static AlarmPopUp inst;
    private TimePickerDialog timePickerDialog;
    final static int RQS_1 = 1;
    private PreferencesHelper preferencesHelper;
    public Switch alarmToggle;
    private Calendar calSet;
    private Cursor mCursor;
    private TaskDbHelper mTaskdbHelper;
    private Context mContext;
    public static AlarmPopUp instance() {
        return inst;
    }

    public AlarmPopUp(){
        mContext = getBaseContext();
        inst = this;
    };

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTaskdbHelper = new TaskDbHelper(this);
        setContentView(R.layout.alarmpopup);
        inst = this;

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .3));
        alarmToggle = (Switch) findViewById(R.id.alarmToggle);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        preferencesHelper = new PreferencesHelper(getApplicationContext());
        alarmToggle.setChecked(preferencesHelper.loadBoolean(PreferencesHelper.PREFERENCE_TOGGLE_BTN_VALUE));
    }


    TimePickerDialog.OnTimeSetListener onTimeSetListener
            = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Calendar calNow = Calendar.getInstance();
            calSet = (Calendar) calNow.clone();
            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);
            if (calSet.compareTo(calNow) <= 0) {
                calSet.add(Calendar.DATE, 1);
            }
        }
    };

    TimePickerDialog.OnDismissListener onDismissListener
            = new TimePickerDialog.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialog) {
      //      mTaskdbHelper.updateAlarmOn("0", mTaskdbHelper.getIdByIndex(positionIndex));
        }
    };

    TimePickerDialog.OnCancelListener onCancelListener
            = new TimePickerDialog.OnCancelListener() {

        @Override
        public void onCancel(DialogInterface dialog) {
   //         mTaskdbHelper.updateAlarmOn("0", mTaskdbHelper.getIdByIndex(positionIndex));
        }
    };

    public void onToggleClicked(View view) {
  //      mTaskdbHelper.updateAlarmOn("1", mTaskdbHelper.getIdByIndex(mCursor.getPosition()));
        Calendar calendar = Calendar.getInstance();
        if(alarmToggle.isChecked()) {
            timePickerDialog = new TimePickerDialog(
                    AlarmPopUp.this,
                    TimePickerDialog.THEME_HOLO_DARK,
                    onTimeSetListener,
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true);
            timePickerDialog.setTitle("Set Alarm Time");
            timePickerDialog.setOnCancelListener(onCancelListener);
            timePickerDialog.setOnDismissListener(onDismissListener);
            timePickerDialog.show();
        }
        else {
     //       mTaskdbHelper.updateAlarmOn("0", mTaskdbHelper.getIdByIndex(mCursor.getPosition()));
            //ugasi alarm ako je postojao
        }
    }

    public void setAlarm(Calendar calendar) {
        String sati = intToString(calendar.getTime().getHours());
        String minuti = intToString(calendar.getTime().getMinutes());
        String dan = String.valueOf(calendar.getTime().getDate());
        int datum =  Integer.parseInt(dan + sati + minuti);
        Log.d("SleepQuality", "Setovan alarm: " + datum);
        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(getBaseContext(), datum, intent, 0);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    public void cancelAlarm(Calendar calendar) {
        String sati = intToString(calendar.getTime().getHours());
        String minuti = intToString(calendar.getTime().getMinutes());
        String dan = String.valueOf(calendar.getTime().getDate());
        int datum =  Integer.parseInt(dan + sati + minuti);

        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, datum, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);
        Log.d("SleepQuality", "Cancelovan alarm: " + datum);
        alarmManager.cancel(pendingIntent);
        pendingIntent.cancel();
    }


    /**
     * onClickAddTask is called when the "ADD" button is clicked.
     * It retrieves user input and inserts that new task data into the underlying database.
     */
    public void onClickAddTask(View view) {
        String input = ((EditText) findViewById(R.id.editTextTaskDescription)).getText().toString();

        if (input.length() == 0) {
            return;
        }

        //promeniti da moze da se dodaje i updateuje u zavisnosti od toga da li je kliknuto na add
        //ili na task, a create i update napraviti metodu u taskDbHelperu
        ContentValues contentValues = new ContentValues();
        contentValues.put(TaskContract.TaskEntry.COLUMN_DESCRIPTION, input);
        if(alarmToggle.isChecked() && calSet != null) {
            contentValues.put(TaskContract.TaskEntry.COLUMN_ALARM, calSet.getTime().toString());
            contentValues.put(TaskContract.TaskEntry.COLUMN_ALARM_ON, true);
            setAlarm(calSet);
        }
        else {
            contentValues.put(TaskContract.TaskEntry.COLUMN_ALARM_ON, false);
            alarmToggle.setChecked(false);
        }
        Uri uri = getContentResolver().insert(TaskContract.TaskEntry.CONTENT_URI, contentValues);
        Log.d("SleepQuality", "Unet task: " + contentValues);
        finish();
    }



    private String intToString(int integer) {
        String string;
        if(String.valueOf(integer).length() == 0) {
            string = "00";
        }
        else if(String.valueOf(integer).length() == 1) {
            string = "0" + String.valueOf(integer);
        }
        else {
            string = String.valueOf(integer);
        }

        return string;
    }
}

