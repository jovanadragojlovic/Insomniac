package com.example.nikola.insomniac.improveSleep;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.ImproveSleep;
import com.example.nikola.insomniac.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NightlyLight extends ImproveSleep {

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd;
    private EditText editText;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nightlylight);

        ImageButton nl = (ImageButton) findViewById(R.id.nl);


        mDatabaseHelper = new DatabaseHelper(this);


        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        TextView resultsnightlylight = (TextView)findViewById(R.id.resultsnightlylight);

        if (mDatabaseHelper.getNightlyLightByDate(date)!= null) {

            double doubleseconds = Double.parseDouble(mDatabaseHelper.getNightlyLightByDate(date));

            long seconds = (long)doubleseconds;

            long hours = TimeUnit.SECONDS.toHours(seconds);

            seconds -= TimeUnit.HOURS.toMillis(hours);
            long minutes = TimeUnit.SECONDS.toMinutes(seconds);

            String Hours = String.valueOf(hours);
            String Minutes = String.valueOf(minutes);

            resultsnightlylight.setText("Time spent under light this evening: " + Hours + " hours " + Minutes + " minutes ");
        }
        else resultsnightlylight.setText("Nightly light: 0");


        Button refresh = (Button)findViewById(R.id.refresh);
        refresh.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(NightlyLight.this, NightlyLight.class);
                        NightlyLight.this.startActivity(myIntent);
                    }

                });



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry);
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
                            Intent myIntent = new Intent(NightlyLight.this, NightlyLightService.class);
                            startService(myIntent);
                        } else {
                            Intent myIntent = new Intent(NightlyLight.this, NightlyLightService.class);
                            stopService(myIntent);
                        }
                    }

                });


        nl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                // nl_info dialog
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.nl_info);


                // set the nl_info dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.text);

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



    public void AddData(String newEntry) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        try {
            mDatabaseHelper.addNightlyLightData(newEntry, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }


    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}
