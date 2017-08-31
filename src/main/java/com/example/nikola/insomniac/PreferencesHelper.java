package com.example.nikola.insomniac;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesHelper {

    private static final String PREFERENCE_NAME = "preferences";
    private static final Boolean BOOLEAN_DEFAULT_VALUE = false;
    private static final String STRING_DEFAULT_VALUE = "";


    public static final String PREFERENCE_TOGGLE_BTN_VALUE = "toggle_button";





    private Context context;
    private SharedPreferences preferences;

    public PreferencesHelper(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
    }

    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key,value);
        editor.apply();
    }

    public String loadString(String key) {
        return preferences.getString(key, STRING_DEFAULT_VALUE);
    }


    public void saveBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public boolean loadBoolean(String key) {
        return preferences.getBoolean(key, BOOLEAN_DEFAULT_VALUE);
    }

    public void clearAll() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }


}
