package com.example.nikola.insomniac.improveSleep;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.example.nikola.insomniac.DatabaseHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NightlyLightService extends Service implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mLight;

    //Ove variable sam napravio cisto da vidim kako sensor radi
    private String lux_light;
    ArrayList<String> listaluxa = new ArrayList<String>();
    TextView textLIGHT_reading;

    //ove koristim za merenje vremena
    private float luks;

    //ove za Log i merenje vremena
    String StringElapsedTimeNighlyLight;
    String StringElapsedTimeDailyligjt;

    //ove za databazu
    DatabaseHelper mDatabaseHelper;
    String nightlyLight;
    final Context context = this;

    //za hours of the day
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);

    //counteri
    double counternigtlylight;

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //generated
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        luks = event.values[0];

        lux_light = String.valueOf(event.values[0]);
        listaluxa.add(lux_light);
        Log.d("list", listaluxa.toString());

        if (hour > 19 && hour <=23) {
            if (luks >0) {
                counternigtlylight = counternigtlylight + 0.2;
                StringElapsedTimeNighlyLight = String.valueOf(counternigtlylight);
                Log.d("Sa  svetlom   -", StringElapsedTimeNighlyLight);
                nightlyLight = StringElapsedTimeNighlyLight;
            }
            else if (counternigtlylight != 0) {
                AddData(nightlyLight);
                counternigtlylight = 0;
            }
        }

        if (hour == 0 && nightlyLight != "0") {
            AddData(nightlyLight);
            nightlyLight = "0";
            counternigtlylight = 0;

        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "MyService Started.", Toast.LENGTH_SHORT).show();

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        mSensorManager.registerListener(this, mLight, 1000000000);

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // ignore this since not linked to an activity
        return null;
    }

    @Override
    public void onDestroy() {
        mSensorManager.unregisterListener(this, mLight);
        Toast.makeText(this, "MyService Completed", Toast.LENGTH_SHORT).show();
    }

    public void AddData(String nightlyLight) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        try {
            mDatabaseHelper = new DatabaseHelper(context);
            mDatabaseHelper.addNightlyLightData(nightlyLight, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }


    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}