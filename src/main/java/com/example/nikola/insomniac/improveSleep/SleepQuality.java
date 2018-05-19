package com.example.nikola.insomniac.improveSleep;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.ImproveSleep;
import com.example.nikola.insomniac.MainActivity;
import com.example.nikola.insomniac.R;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import static android.R.attr.y;
import static com.example.nikola.insomniac.R.id.dl;

public class SleepQuality extends ImproveSleep {

    DatabaseHelper mDatabaseHelper;

    private Button btnSave, btnClose;

    final Context context = this;

    RatingBar simpleRatingBar;
    SeekBar simpleSeekBar;
    TextView textView0;
    TextView textView2;
    TextView textView4;

    int SRB;
    String SSB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleepquality);

        btnSave = (Button) findViewById(R.id.save);
        btnClose = (Button) findViewById(R.id.close);

        mDatabaseHelper = new DatabaseHelper(this);
        ImageButton sq = (ImageButton) findViewById(R.id.sq);

        simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        simpleSeekBar = (SeekBar) findViewById(R.id.seekBar);
        simpleSeekBar.setMax(10);

        textView0 = (TextView) findViewById(R.id.tw0);
        textView2 = (TextView) findViewById(R.id.tw2);
        textView4 = (TextView) findViewById(R.id.tw4);


        String date = new SimpleDateFormat("dd-MM-yyyy").format(yesterday());
        textView0.setText("Date: " + date);

        btnClose.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(SleepQuality.this, MainActivity.class);
                        SleepQuality.this.startActivity(myIntent);
                    }
                }
        );

        simpleRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if (v <=1) {
                    textView4.setText("Poor");
                    SRB = 1; }
                else if (v > 1 && v <=2) {
                    textView4.setText("Fair");
                    SRB = 2; }
                else if (v > 2 && v <=3) {
                    textView4.setText("Good");
                    SRB = 3;}
                else if (v >3 && v <=4) {
                    textView4.setText("Very good");
                    SRB = 4; }
                else {
                    textView4.setText("Excellent");
                    SRB = 5; }
                }
            } );


        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressChangedValue = i;
                textView2.setText(progressChangedValue + " hours");
                SSB = String.valueOf(progressChangedValue);}

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String SleepQuality = String.valueOf(SRB);
                String SleepingTime = SSB;

                if (SRB != 0) {
                    AddData(SleepQuality);
                }
                if (SSB != null) {
                    AddData2(SleepingTime);
                }
            }
        });


        sq.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                // nl_info dialog
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.sq_info);


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
        String date = new SimpleDateFormat("dd-MM-yyyy").format(yesterday());
        try {
            mDatabaseHelper.addSleepQualityData(newEntry, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    public void AddData2(String newEntry) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(yesterday());
        try {
            mDatabaseHelper.addSleepingTime(newEntry, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}
