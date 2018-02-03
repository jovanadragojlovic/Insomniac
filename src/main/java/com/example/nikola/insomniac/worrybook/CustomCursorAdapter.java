/*
* Copyright (C) 2016 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.nikola.insomniac.worrybook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;


import com.example.nikola.insomniac.R;
import com.example.nikola.insomniac.alarms.AlarmReceiver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.content.Context.ALARM_SERVICE;
import static com.example.nikola.insomniac.R.id.alarmpopup;
import static com.example.nikola.insomniac.R.id.taskDescription;


/**
 * This CustomCursorAdapter creates and binds ViewHolders, that hold the description and priority of a task,
 * to a RecyclerView to efficiently display data.
 */
public class CustomCursorAdapter extends RecyclerView.Adapter<CustomCursorAdapter.TaskViewHolder> {

    // Class variables for the Cursor that holds task data and the Context
    private Cursor mCursor;
    private Context mContext;
    private AlarmManager alarmManager;
    private TaskDbHelper mTaskdbHelper;
    private TimePickerDialog timePickerDialog;
    private Calendar calSet;
    private int alarmOn;
    private int positionIndex;
    private AlarmPopUp alarmPopUp = new AlarmPopUp();

    /**
     * Constructor for the CustomCursorAdapter that initializes the Context.
     *
     * @param mContext the current Context
     */
    public CustomCursorAdapter(Context mContext) {
        this.mContext = mContext;
    }


    /**
     * Called when ViewHolders are created to fill a RecyclerView.
     *
     * @return A new TaskViewHolder that holds the view for each task
     */
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Inflate the task_layout to a view
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.task_layout, parent, false);
        alarmManager = (AlarmManager) mContext.getSystemService(ALARM_SERVICE);
        mTaskdbHelper = new TaskDbHelper(mContext);
        return new TaskViewHolder(view);
    }


    /**
     * Called by the RecyclerView to display data at a specified position in the Cursor.
     *
     * @param holder The ViewHolder to bind Cursor data to
     * @param position The position of the data in the Cursor
     */
    @Override
    public void onBindViewHolder(final TaskViewHolder holder, final int position) {

        // Indices for the _id, description, and priority columns
        positionIndex = position;
        int idIndex = mCursor.getColumnIndex(TaskContract.TaskEntry._ID);
        int descriptionIndex = mCursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_DESCRIPTION);
        int alarmIndex = mCursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_ALARM);
        int alarmOnIndex = mCursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_ALARM_ON);

        mCursor.moveToPosition(position); // get to the right location in the cursor
        // Determine the values of the wanted data
        final int id = mCursor.getInt(idIndex);
        String description = mCursor.getString(descriptionIndex);
        String alarm = mCursor.getString(alarmIndex);
        alarmOn = mCursor.getInt(alarmOnIndex);
        if(alarmOn != 0) {
            holder.checkBox.setBackgroundResource(R.drawable.alarm_clock_green);
        }
        else {
            holder.checkBox.setBackgroundResource(R.drawable.alarm_clock_white);
        }


        //Set values
        holder.itemView.setTag(id);
        holder.taskDescriptionView.setText(description);
        holder.checkBox.setChecked(alarmOn != 0);


        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String alarm = mTaskdbHelper.getAlarmByIndex(position);
                Date date;

                if(alarm != null) {
                    date = new Date(alarm);
                }

                else {
                    date = new Date();
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                if(alarmPopUp != null){

                    if(isChecked) {
                        holder.checkBox.setBackgroundResource(R.drawable.alarm_clock_green);
                        ContentValues contentValues = new ContentValues();
                        if(alarm != null) {
                            mTaskdbHelper.updateAlarmOn("1", mTaskdbHelper.getIdByIndex(position));
                            alarmPopUp.setAlarm(calendar);
                        }
                        else {
                            timePickerDialog = new TimePickerDialog(
                                    AlarmPopUp.instance(),
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

                        int uri = mContext.getContentResolver().update(  //mozda insert ne update
                                TaskContract.TaskEntry.CONTENT_URI,
                                contentValues,
                                null,
                                null);
                    }
                    else {
                        holder.checkBox.setBackgroundResource(R.drawable.alarm_clock_white);
                        mTaskdbHelper.updateAlarmOn("0", mTaskdbHelper.getIdByIndex(position));
                        alarmPopUp.cancelAlarm(calendar);
                    }
                }
            }
        });
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
            mTaskdbHelper.updateAlarm(calSet.getTime().toString(),
                    mTaskdbHelper.getIdByIndex(positionIndex));
            mTaskdbHelper.updateAlarmOn("1", mTaskdbHelper.getIdByIndex(positionIndex));

        }
    };

    TimePickerDialog.OnDismissListener onDismissListener
            = new TimePickerDialog.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialog) {
            alarmOn = 0;
            mTaskdbHelper.updateAlarmOn("0", mTaskdbHelper.getIdByIndex(positionIndex));
        }
    };

    TimePickerDialog.OnCancelListener onCancelListener
            = new TimePickerDialog.OnCancelListener() {

        @Override
        public void onCancel(DialogInterface dialog) {
            alarmOn = 0;
            mTaskdbHelper.updateAlarmOn("0", mTaskdbHelper.getIdByIndex(positionIndex));
        }
    };

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


    /**
     * Returns the number of items to display.
     */
    @Override
    public int getItemCount() {
        if (mCursor == null) {
            return 0;
        }
        return mCursor.getCount();
    }


    /**
     * When data changes and a re-query occurs, this function swaps the old Cursor
     * with a newly updated Cursor (Cursor c) that is passed in.
     */
    public Cursor swapCursor(Cursor c) {
        // check if this cursor is the same as the previous cursor (mCursor)
        if (mCursor == c) {
            return null; // bc nothing has changed
        }
        Cursor temp = mCursor;
        this.mCursor = c; // new cursor value assigned

        //check if this is a valid cursor, then update the cursor
        if (c != null) {
            this.notifyDataSetChanged();
        }
        return temp;
    }


    // Inner class for creating ViewHolders
    class TaskViewHolder extends RecyclerView.ViewHolder {

        // Class variables for the task description and priority TextViews
        TextView taskDescriptionView;
        CheckBox checkBox;

        /**
         * Constructor for the TaskViewHolders.
         *
         * @param itemView The view inflated in onCreateViewHolder
         */
        public TaskViewHolder(View itemView) {
            super(itemView);

            taskDescriptionView = (TextView) itemView.findViewById(taskDescription);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }
}