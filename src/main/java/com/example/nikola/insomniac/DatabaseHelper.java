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

    private static final String SLEEP_QUALITY = "SleepQuality";
    private static final String PHYSICAL_ACTIVITY = "PhysicalActivity";
    private static final String DAILY_LIGHT = "DailyLight";
    private static final String NIGHTLY_LIGHT = "NightlyLight";
    private static final String WATER = "Water";
    private static final String FOOD = "Food";
    private static final String COFFEE = "Coffee";
    private static final String BEDROOM = "Bedroom";

    private static final String COL1 = "Date";

    private static final String SQ_COL2 = "SleepQuality";

    private static final String PA_COL2 = "Steps";
    private static final String PA_COL3 = "Running";
    private static final String PA_COL4 = "Sport";

    private static final String DL_COL2 = "AverageLux";

    private static final String NL_COL2 = "AverageLux";

    private static final String W_COL2 = "WaterAmount";

    private static final String F_COL2 = "WaterAmount";
    private static final String F_COL3 = "Carbs";
    private static final String F_COL4 = "Fats";
    private static final String F_COL5 = "Protein";

    private static final String C_COL2 = "CoffeeAmount";

    private static final String B_COL2 = "Temperature";
    private static final String B_COL3 = "Humidity";


    public DatabaseHelper(Context context) {
        super(context, SLEEP_QUALITY, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQTable = "CREATE TABLE " + SLEEP_QUALITY + " (" + COL1 + " TEXT PRIMARY KEY," +
                SQ_COL2 + " TEXT);";
        String createPATable = "CREATE TABLE " + PHYSICAL_ACTIVITY + " (DATE TEXT PRIMARY KEY, " +
                PA_COL2 + " TEXT, " + PA_COL3 + " TEXT, " + PA_COL4 + " TEXT)";
        String createDLTable = "CREATE TABLE " + DAILY_LIGHT + " (DATE TEXT PRIMARY KEY, " +
                DL_COL2 + " TEXT)";
        String createNLTable = "CREATE TABLE " + NIGHTLY_LIGHT + " (DATE TEXT PRIMARY KEY, " +
                NL_COL2 + " TEXT)";
        String createWTable = "CREATE TABLE " + WATER + " (DATE TEXT PRIMARY KEY, " +
                W_COL2 + " TEXT)";
        String createFTable = "CREATE TABLE " + FOOD + " (DATE TEXT PRIMARY KEY, " +
                F_COL2 + " TEXT, " + F_COL3 + " TEXT, " +  F_COL4 + " TEXT, " +  F_COL5 + " TEXT)";
        String createCTable = "CREATE TABLE " + COFFEE + " (DATE TEXT PRIMARY KEY, " +
                C_COL2 + " TEXT)";
        String createBTable = "CREATE TABLE " + BEDROOM + " (DATE TEXT PRIMARY KEY, " +
                B_COL2 + " TEXT, " + B_COL3 + " TEXT)";

        db.execSQL(createSQTable);
        db.execSQL(createPATable);
        db.execSQL(createDLTable);
        db.execSQL(createNLTable);
        db.execSQL(createWTable);
        db.execSQL(createFTable);
        db.execSQL(createCTable);
        db.execSQL(createBTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + SLEEP_QUALITY);
        db.execSQL("DROP IF TABLE EXISTS " + PHYSICAL_ACTIVITY);
        db.execSQL("DROP IF TABLE EXISTS " + DAILY_LIGHT);
        db.execSQL("DROP IF TABLE EXISTS " + NIGHTLY_LIGHT);
        db.execSQL("DROP IF TABLE EXISTS " + WATER);
        db.execSQL("DROP IF TABLE EXISTS " + FOOD);
        db.execSQL("DROP IF TABLE EXISTS " + COFFEE);
        db.execSQL("DROP IF TABLE EXISTS " + BEDROOM);
        onCreate(db);
    }

    public void addSleepQualityData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(SQ_COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + SLEEP_QUALITY);
        Log.d(TAG, "addData: Adding " + date + " to " + SLEEP_QUALITY);
        if(getDataValues("SleepQuality", "Date").contains(date)) {

            updateSleepQuality(item, date);
        }
        else {
            db.insert(SLEEP_QUALITY, null, contentValues);
        }
      //  Log.d(TAG, "Sleep Quality of today: " + getSleepQualityByDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date())));
    }

    public void addPhysicalActivitySteps(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(PA_COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + PHYSICAL_ACTIVITY);
        Log.d(TAG, "addData: Adding " + date + " to " + PHYSICAL_ACTIVITY);


        if(getDataValues("PhysicalActivity", "Date").contains(date)) {
            updateSteps(item, date);
        }
        else {
            db.insert(PHYSICAL_ACTIVITY, null, contentValues);
        }
    }

    public void addPhysicalActivityRunning(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(PA_COL3, item);

        Log.d(TAG, "addData: Adding " + item + " to " + PHYSICAL_ACTIVITY);
        Log.d(TAG, "addData: Adding " + date + " to " + PHYSICAL_ACTIVITY);

        if(getDataValues("PhysicalActivity", "Date").contains(date)) {
            updateRunning(item, date);
        }
        else {
            db.insert(PHYSICAL_ACTIVITY, null, contentValues);
        }
    }

    public void addPhysicalActivitySport(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(PA_COL4, item);

        Log.d(TAG, "addData: Adding " + item + " to " + PHYSICAL_ACTIVITY);
        Log.d(TAG, "addData: Adding " + date + " to " + PHYSICAL_ACTIVITY);

        if(getDataValues("PhysicalActivity", "Date").contains(date)) {
            updateSport(item, date);
        }
        else {
            db.insert(PHYSICAL_ACTIVITY, null, contentValues);
        }
    }

    public void addDailyLightData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(DL_COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + DAILY_LIGHT);
        Log.d(TAG, "addData: Adding " + date + " to " + DAILY_LIGHT);

        if(getDataValues("DailyLight", "Date").contains(date)) {
            updateDailyLight(item, date);
        }
        else {
            db.insert(DAILY_LIGHT, null, contentValues);
        }
    }

    public void addNightlyLightData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(NL_COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + NIGHTLY_LIGHT);
        Log.d(TAG, "addData: Adding " + date + " to " + NIGHTLY_LIGHT);

        if(getDataValues("NightlyLight", "Date").contains(date)) {
            updateNightlyLight(item, date);
        }
        else {
            db.insert(NIGHTLY_LIGHT, null, contentValues);
        }
    }

    public void addWaterData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(W_COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + WATER);
        Log.d(TAG, "addData: Adding " + date + " to " + WATER);

        if(getDataValues("Water", "Date").contains(date)) {
            updateWater(item, date);
        }
        else {
            db.insert(WATER, null, contentValues);
        }
    }

    public void addCoffeeData(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(C_COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + COFFEE);
        Log.d(TAG, "addData: Adding " + date + " to " + COFFEE);

        if(getDataValues("Coffee", "Date").contains(date)) {
            updateCoffee(item, date);
        }
        else {
            db.insert(COFFEE, null, contentValues);
        }
    }

    public void addBedroomTemperature(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(B_COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + BEDROOM);
        Log.d(TAG, "addData: Adding " + date + " to " + BEDROOM);

        if(getDataValues("Bedroom", "Date").contains(date)) {
            updateTemperature(item, date);
        }
        else {
            db.insert(BEDROOM, null, contentValues);
        }
    }

    public void addBedroomHumidity(String item, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, date);
        contentValues.put(B_COL3, item);

        Log.d(TAG, "addData: Adding " + item + " to " + BEDROOM);
        Log.d(TAG, "addData: Adding " + date + " to " + BEDROOM);

        if(getDataValues("Bedroom", "Date").contains(date)) {
            updateHumidity(item, date);
        }
        else {
            db.insert(BEDROOM, null, contentValues);
        }
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

    public String getSleepQualityByDate(String date) {
       ArrayList<String> dateValues = getDataValues("SleepQuality", "Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "Sleep Quality values: " +  getDataValues("SleepQuality", "SleepQuality"));
        try {
            return getDataValues("SleepQuality", "SleepQuality").get(dateValues.indexOf(date));
        }catch (ArrayIndexOutOfBoundsException error) {
            return null;
        }

    }

    public String getDailyLightByDate(String date) {
        ArrayList<String> dateValues = getDataValues("DailyLight", "Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "DailyLight values: " +  getDataValues("DailyLight", "AverageLux"));
        return getDataValues("DailyLight", "AverageLux").get(dateValues.indexOf(date));
    }

    public String getNightlyLightByDate(String date) {
        ArrayList<String> dateValues = getDataValues("NightlyLight", "Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "NightlyLight values: " +  getDataValues("NightlyLight", "AverageLux"));
        try {
            return getDataValues("NightlyLight", "AverageLux").get(dateValues.indexOf(date));
        }catch (ArrayIndexOutOfBoundsException error){
            return null;
        }
    }

    public String getStepsByDate(String date) {
        ArrayList<String> dateValues = getDataValues("PhysicalActivity", "Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "PhysicalActivity values: " +  getDataValues("PhysicalActivity", "Steps"));
        return getDataValues("PhysicalActivity", "Steps").get(dateValues.indexOf(date));
    }

    public String getRunningByDate(String date) {
        ArrayList<String> dateValues = getDataValues("PhysicalActivity", "Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "PhysicalActivity values: " +  getDataValues("PhysicalActivity", "Running"));
        return getDataValues("PhysicalActivity", "Running").get(dateValues.indexOf(date));
    }

    public String getSportByDate(String date) {
        ArrayList<String> dateValues = getDataValues("PhysicalActivity", "Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "PhysicalActivity values: " +  getDataValues("PhysicalActivity", "Sport"));
        return getDataValues("PhysicalActivity", "Sport").get(dateValues.indexOf(date));
    }

    public String getWaterByDate(String date) {
        ArrayList<String> dateValues = getDataValues("Water", "Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "Water values: " +  getDataValues("Water", "WaterAmount"));
        return getDataValues("Water", "WaterAmount").get(dateValues.indexOf(date));
    }

    public String getCoffeeByDate(String date) {
        ArrayList<String> dateValues = getDataValues("Coffee", "Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "Coffee values: " +  getDataValues("Coffee", "CoffeeAmount"));
        try {
            return getDataValues("Coffee", "CoffeeAmount").get(dateValues.indexOf(date));
        }catch (ArrayIndexOutOfBoundsException error){
            return null;
        }

    }

    public String getTemperatureByDate(String date) {
        ArrayList<String> dateValues = getDataValues("Bedroom", "Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "Bedroom values: " +  getDataValues("Bedroom", "Temperature"));
        return getDataValues("Bedroom", "Temperature").get(dateValues.indexOf(date));
    }

    public String getHumidityByDate(String date) {
        ArrayList<String> dateValues = getDataValues("Bedroom", "Date");
        Log.d(TAG, "Date values: " + dateValues);
        Log.d(TAG, "Bedroom values: " +  getDataValues("Bedroom", "Humidity"));
        try {
            return getDataValues("Bedroom", "Humidity").get(dateValues.indexOf(date));
        }catch (ArrayIndexOutOfBoundsException error){
            return null;
        }
    }

    public void updateSleepQuality(String sleepQuality, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + SLEEP_QUALITY + " SET " + SQ_COL2 +
                " = '" + sleepQuality + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting sleepQuality to " + sleepQuality);
        db.execSQL(query);
    }

    public void updateSteps(String steps, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        int lastSteps = Integer.parseInt(this.getStepsByDate(date));
        lastSteps += Integer.parseInt(steps);
        String query = "UPDATE " + PHYSICAL_ACTIVITY + " SET " + PA_COL2 +
                " = '" + String.valueOf(lastSteps) + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting steps to " + String.valueOf(lastSteps));
        db.execSQL(query);
    }

    public void updateRunning(String running, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        int lastRunning = Integer.parseInt(this.getRunningByDate(date));
        lastRunning += Integer.parseInt(running);
        String query = "UPDATE " + PHYSICAL_ACTIVITY + " SET " + PA_COL3 +
                " = '" + String.valueOf(lastRunning) + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting running to " + String.valueOf(lastRunning));
        db.execSQL(query);
    }

    public void updateSport(String sport, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        int lastSport = Integer.parseInt(this.getSportByDate(date));
        lastSport += Integer.parseInt(sport);
        String query = "UPDATE " + PHYSICAL_ACTIVITY + " SET " + PA_COL4 +
                " = '" + String.valueOf(lastSport) + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting sport to " + String.valueOf(lastSport));
        db.execSQL(query);
    }

    public void updateDailyLight(String dailyLight, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        int lastDailyLight = Integer.parseInt(this.getDailyLightByDate(date));
        lastDailyLight += Integer.parseInt(dailyLight);
        String query = "UPDATE " + DAILY_LIGHT + " SET " + DL_COL2 +
                " = '" + String.valueOf(lastDailyLight) + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting dailyLight to " + String.valueOf(lastDailyLight));
        db.execSQL(query);
    }

    public void updateNightlyLight(String nightlyLight, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        int lastNightlyLight = Integer.parseInt(this.getNightlyLightByDate(date));
        lastNightlyLight = Integer.parseInt(nightlyLight);
        String query = "UPDATE " + NIGHTLY_LIGHT + " SET " + NL_COL2 +
                " = '" + String.valueOf(lastNightlyLight) + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting nightlyLight to " + String.valueOf(lastNightlyLight));
        db.execSQL(query);
    }

    public void updateWater(String water, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        int lastWater = Integer.parseInt(this.getWaterByDate(date));
        lastWater += Integer.parseInt(water);
        String query = "UPDATE " + WATER + " SET " + W_COL2 +
                " = '" + String.valueOf(lastWater) + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting water to " + String.valueOf(lastWater));
        db.execSQL(query);
    }

    public void updateCoffee(String coffee, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + COFFEE + " SET " + C_COL2 +
                " = '" + String.valueOf(coffee) + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting coffee to " + String.valueOf(coffee));
        db.execSQL(query);
    }

    public void updateTemperature(String temperature, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        int lastTemperature = Integer.parseInt(this.getTemperatureByDate(date));
        lastTemperature += Integer.parseInt(temperature);
        String query = "UPDATE " + BEDROOM + " SET " + B_COL2 +
                " = '" + String.valueOf(lastTemperature) + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting temperature to " + String.valueOf(lastTemperature));
        db.execSQL(query);
    }

    public void updateHumidity(String humidity, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        int lastHumidity = Integer.parseInt(this.getHumidityByDate(date));
        lastHumidity = Integer.parseInt(humidity);
        String query = "UPDATE " + BEDROOM + " SET " + B_COL3 +
                " = '" + String.valueOf(lastHumidity) + "' WHERE " + COL1 + " = '" + date + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting humidity to " + String.valueOf(lastHumidity));
        db.execSQL(query);
    }

    public void deleteSleepQualityByDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + SLEEP_QUALITY + " WHERE "
                + COL1 + " = '" + date + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + date + " from database.");
        db.execSQL(query);
    }

    public void deletePhysicalActivityByDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + PHYSICAL_ACTIVITY + " WHERE "
                + COL1 + " = '" + date + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + date + " from database.");
        db.execSQL(query);
    }

    public void deleteDailyLightLByDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + DAILY_LIGHT + " WHERE "
                + COL1 + " = '" + date + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + date + " from database.");
        db.execSQL(query);
    }

    public void deleteNightlyLightByDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + NIGHTLY_LIGHT + " WHERE "
                + COL1 + " = '" + date + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + date + " from database.");
        db.execSQL(query);
    }

    public void deleteWaterByDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + WATER + " WHERE "
                + COL1 + " = '" + date + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + date + " from database.");
        db.execSQL(query);
    }

    public void deleteFoodByDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + FOOD + " WHERE "
                + COL1 + " = '" + date + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + date + " from database.");
        db.execSQL(query);
    }

    public void deleteCoffeeByDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + COFFEE + " WHERE "
                + COL1 + " = '" + date + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + date + " from database.");
        db.execSQL(query);
    }

    public void deleteBedroomByDate(String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + BEDROOM + " WHERE "
                + COL1 + " = '" + date + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + date + " from database.");
        db.execSQL(query);
    }
}
