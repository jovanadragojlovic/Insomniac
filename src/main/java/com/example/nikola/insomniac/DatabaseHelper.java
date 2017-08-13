package com.example.nikola.insomniac;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SleepQuality";

    private static final String TABLE_NAME = "ImproveSleep";
    private static final String COL1 = "Date";
    private static final String COL2 = "SleepQuality";
    private static final String COL3 = "DailyLight";
    private static final String COL4 = "NightlyLight";
    private static final String COL5 = "PhysicalActivity";
    private static final String COL6 = "Water";
    private static final String COL7 = "Coffee";
    private static final String COL8 = "Bedroom";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (DATE TEXT PRIMARY KEY, " +
                COL2 +" TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " TEXT, "
                + COL6 + " TEXT, " + COL7 + " TEXT, " + COL8 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addSleepQualityData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + date + " to " + TABLE_NAME);
        if(getDataValues("Date").contains(date)) {
            updateSleepQuality(item, date);
        }
        else {
            db.insert(TABLE_NAME, null, contentValues);
        }
        Log.d(TAG, "Sleep Quality of today: " + getSleepQualityByDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date())));
    }

    public void addDailyLightData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(COL3, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + date + " to " + TABLE_NAME);

        if(getDataValues("Date").contains(date)) {
            updateDailyLight(item, date);
        }
        else {
            db.insert(TABLE_NAME, null, contentValues);
        }
    }

    public void addNightlyLightData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(COL4, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + date + " to " + TABLE_NAME);

        if(getDataValues("Date").contains(date)) {
            updateNightlyLight(item, date);
        }
        else {
            db.insert(TABLE_NAME, null, contentValues);
        }
    }

    public void addPhysicalActivityData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(COL5, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + date + " to " + TABLE_NAME);

        if(getDataValues("Date").contains(date)) {
            updatePhisycalActivity(item, date);
        }
        else {
            db.insert(TABLE_NAME, null, contentValues);
        }
    }

    public void addWaterData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(COL6, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + date + " to " + TABLE_NAME);

        if(getDataValues("Date").contains(date)) {
            updateWater(item, date);
        }
        else {
            db.insert(TABLE_NAME, null, contentValues);
        }
    }

    public void addCoffeeData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(COL7, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + date + " to " + TABLE_NAME);

        if(getDataValues("Date").contains(date)) {
            updateCoffee(item, date);
        }
        else {
            db.insert(TABLE_NAME, null, contentValues);
        }
    }

    public void addBedroomData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(COL8, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + date + " to " + TABLE_NAME);

        if(getDataValues("Date").contains(date)) {
            updateBedroom(item, date);
        }
        else {
            db.insert(TABLE_NAME, null, contentValues);
        }
    }

    public ArrayList<String> getDataValues(String columnName) {
        ArrayList<String> values = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {columnName},null, null, null, null, null); // here emailid is the field name in the table and contantValues.TABLE_NAME is the table name
        if (cursor.moveToFirst()) {
            do {
                values.add(cursor.getString(0));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return values;
    }

    public String getSleepQualityByDate(String date) {
       ArrayList<String> dateValues = getDataValues("Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "Sleep Quality values: " +  getDataValues("SleepQuality"));
        return getDataValues("SleepQuality").get(dateValues.indexOf(date));
    }

    public String getDailyLightByDate(String date) {
        ArrayList<String> dateValues = getDataValues("Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "DailyLight values: " +  getDataValues("DailyLight"));
        return getDataValues("DailyLight").get(dateValues.indexOf(date));
    }

    public String getNightlyLightByDate(String date) {
        ArrayList<String> dateValues = getDataValues("Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "NightlyLight values: " +  getDataValues("NightlyLight"));
        return getDataValues("NightlyLight").get(dateValues.indexOf(date));
    }

    public String getPhysicalActivityByDate(String date) {
        ArrayList<String> dateValues = getDataValues("Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "PhysicalActivity values: " +  getDataValues("PhysicalActivity"));
        return getDataValues("PhysicalActivity").get(dateValues.indexOf(date));
    }

    public String getWaterByDate(String date) {
        ArrayList<String> dateValues = getDataValues("Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "Water values: " +  getDataValues("Water"));
        return getDataValues("Water").get(dateValues.indexOf(date));
    }

    public String getCoffeeByDate(String date) {
        ArrayList<String> dateValues = getDataValues("Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "Coffee values: " +  getDataValues("Coffee"));
        return getDataValues("Coffee").get(dateValues.indexOf(date));
    }

    public String getBedroomByDate(String date) {
        ArrayList<String> dateValues = getDataValues("Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "Bedroom values: " +  getDataValues("Bedroom"));
        return getDataValues("Bedroom").get(dateValues.indexOf(date));
    }

    public void updateSleepQuality(String sleepQuality, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + sleepQuality + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting sleepQuality to " + sleepQuality);
        db.execSQL(query);
    }

    public void updateDailyLight(String dailyLight, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL3 +
                " = '" + dailyLight + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting dailyLight to " + dailyLight);
        db.execSQL(query);
    }

    public void updateNightlyLight(String nightlyLight, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL4 +
                " = '" + nightlyLight + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting nightlyLight to " + nightlyLight);
        db.execSQL(query);
    }

    public void updatePhisycalActivity(String phisycalActivity, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL5 +
                " = '" + phisycalActivity + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting phisycalActivity to " + phisycalActivity);
        db.execSQL(query);
    }

    public void updateWater(String water, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL6 +
                " = '" + water + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting water to " + water);
        db.execSQL(query);
    }

    public void updateCoffee(String coffee, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL7 +
                " = '" + coffee + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting coffee to " + coffee);
        db.execSQL(query);
    }

    public void updateBedroom(String bedroom, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL8 +
                " = '" + bedroom + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting bedroom to " + bedroom);
        db.execSQL(query);
    }

    public void deleteByDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + date + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + date + " from database.");
        db.execSQL(query);
    }

}
























