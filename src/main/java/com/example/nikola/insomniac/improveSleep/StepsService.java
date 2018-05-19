package com.example.nikola.insomniac.improveSleep;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.widget.Toast;

import com.example.nikola.insomniac.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.nikola.insomniac.R.id.textView;

public class StepsService extends Service implements SensorEventListener {



    private SensorManager sSensorManager;
    private Sensor mStepCounterSensor;
    private String Steps;


    //ove za databazu
    DatabaseHelper mDatabaseHelper;
    final Context context = this;


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //generated
    }

    @Override
    public void onSensorChanged(SensorEvent event) {


        float[] values = event.values;

        int value = (int) values[0];
        Steps = String.valueOf(value);
        if (value>5){
            AddData(Steps);
            value = 0;
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "MyService Started.", Toast.LENGTH_SHORT).show();


        sSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = sSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);


        sSensorManager.registerListener(this, mStepCounterSensor, SensorManager.SENSOR_DELAY_FASTEST);

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // ignore this since not linked to an activity
        return null;
    }

    @Override
    public void onDestroy() {
        sSensorManager.unregisterListener(this, mStepCounterSensor);
        Toast.makeText(this, "MyService Completed", Toast.LENGTH_SHORT).show();
    }


    public void AddData(String Steps) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        try {
            mDatabaseHelper = new DatabaseHelper(context);
            mDatabaseHelper.addPhysicalActivitySteps(Steps, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}