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

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class TaskDbHelper extends SQLiteOpenHelper {

    // The name of the database
    private static final String DATABASE_NAME = "taskDb.db";

    // If you change the database schema, you must increment the database version
    private static final int VERSION = 2;


    // Constructor
    TaskDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    /**
     * Called when the tasks database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("SleepQuality", "CREATING TABLE");
        // Create tasks table (careful to follow SQL formatting rules)
        final String CREATE_TABLE = "CREATE TABLE "  + TaskContract.TaskEntry.TABLE_NAME + " (" +
                TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY, " +
                TaskContract.TaskEntry.COLUMN_DESCRIPTION + " TEXT, " +
                TaskContract.TaskEntry.COLUMN_ALARM + " TEXT, " +
                TaskContract.TaskEntry.COLUMN_ALARM_ON + " BIT)";

        db.execSQL(CREATE_TABLE);
    }


    /**
     * This method discards the old table of data and calls onCreate to recreate a new one.
     * This only occurs when the version number for this database (DATABASE_VERSION) is incremented.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TaskContract.TaskEntry.TABLE_NAME);
        onCreate(db);
    }

    public String getIdByIndex(int index) {
        return getDataValues("Tasks", "Id").get(index);
    }

    public String getDescriptionByIndex(int index) {
        return getDataValues("Tasks", "Description").get(index);
    }

    public String getDescriptionById(String id) {
        ArrayList<String> idValues = getDataValues("Alarm", "Id");
        return getDataValues("Tasks", "Description").get(idValues.indexOf(id));
    }

    public String getAlarmByIndex(int index) {
        return getDataValues("Tasks", "Alarm").get(index);
    }

    public String getAlarmById(String id) {
        ArrayList<String> idValues = getDataValues("Tasks", "Id");
        return getDataValues("Tasks", "Alarm").get(idValues.indexOf(id));
    }

    public String getAlarmByDescription(String description) {
        ArrayList<String> descriptionValues = getDataValues("Alarm", "Description");
        return getDataValues("Tasks", "Alarm").get(descriptionValues.indexOf(description));
    }

    public String getAlarmOnByIndex(int index) {
        return getDataValues("Tasks", "AlarmOn").get(index);
    }

    public String getAlarmOnById(String id) {
        ArrayList<String> idValues = getDataValues("AlarmOn", "Id");
        return getDataValues("Tasks", "AlarmOn").get(idValues.indexOf(id));
    }

    public String getAlarmOnByDescription(String description) {
        ArrayList<String> descriptionValues = getDataValues("Tasks", "Description");
        return getDataValues("Tasks", "AlarmOn").get(descriptionValues.indexOf(description));
    }

    public void updateDescription(String description, String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int lastDescription = Integer.parseInt(this.getDescriptionById(id));
        lastDescription += Integer.parseInt(description);
        String query = "UPDATE " + TaskContract.TaskEntry.TABLE_NAME + " SET " +
                TaskContract.TaskEntry.COLUMN_DESCRIPTION + " = '" +
                String.valueOf(lastDescription) + "' WHERE " + TaskContract.TaskEntry._ID
                + " = '" + id + "'";
        db.execSQL(query);
    }

    public void updateAlarm(String alarm, String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TaskContract.TaskEntry.TABLE_NAME + " SET " +
                TaskContract.TaskEntry.COLUMN_ALARM + " = '" +
                alarm + "' WHERE " + TaskContract.TaskEntry._ID
                + " = '" + id + "'";
        db.execSQL(query);
    }

    public void updateAlarmOn(String alarmOn, String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TaskContract.TaskEntry.TABLE_NAME + " SET " +
                TaskContract.TaskEntry.COLUMN_ALARM_ON + " = '" +
                alarmOn + "' WHERE " + TaskContract.TaskEntry._ID
                + " = '" + id + "'";
        db.execSQL(query);
    }

    public void deleteTask(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " +  TaskContract.TaskEntry.TABLE_NAME  + " WHERE "
                + TaskContract.TaskEntry._ID + " = '" + id + "'";
        db.execSQL(query);
    }


    public ArrayList<String> getDataValues(String tableName, String columnName) {
        ArrayList<String> values = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(tableName, new String[] {columnName},null, null, null, null, null); // here emailid is the field name in the table and contantValues.TABLE_NAME is the table name
        if (cursor.moveToFirst()) {
            do {
                values.add(cursor.getString(0));

            } while (cursor.moveToNext());
        }

        return values;
    }


}