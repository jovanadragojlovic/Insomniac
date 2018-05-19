package com.example.nikola.insomniac.improveSleep;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.ImproveSleep;
import com.example.nikola.insomniac.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.example.nikola.insomniac.R.id.textView;

public class PhysicalActivity extends ImproveSleep {

    private static final String TAG = "DailyLight";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd;
    private EditText editText;
    private Button pa;
    final Context context = this;
    private TextView textView2;
    private String Steps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physicalactivity);

        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        mDatabaseHelper = new DatabaseHelper(this);

        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        textView2 = (TextView) findViewById(R.id.textView2);


        ImageButton pa = (ImageButton) findViewById(R.id.pa);

        if (mDatabaseHelper.getStepsByDate(date) !=null) {
            Steps = mDatabaseHelper.getStepsByDate(date);
            textView2.setText("Steps: " + Steps);
        }
        else textView2.setText("Steps: 0");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    AddSport(newEntry);
                    editText.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }
            }
        });

        final Switch swich1 = (Switch) findViewById(R.id.switch1);
        swich1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if (swich1.isChecked()) {
                            Intent myIntent = new Intent(PhysicalActivity.this, StepsService.class);
                            startService(myIntent);
                        } else {
                            Intent myIntent = new Intent(PhysicalActivity.this, StepsService.class);
                            stopService(myIntent);
                        }
                    }

                });

        pa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                // nl_info dialog
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.pa_info);


                // set the nl_info dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setMovementMethod(new ScrollingMovementMethod());

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the nl_info dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }});
    }

    public void AddSteps(String newEntry) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        try {
            mDatabaseHelper.addPhysicalActivitySteps(newEntry, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    public void AddRunning(String newEntry) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        try {
            mDatabaseHelper.addPhysicalActivityRunning(newEntry, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    public void AddSport(String newEntry) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        try {
            mDatabaseHelper.addPhysicalActivitySport(newEntry, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
