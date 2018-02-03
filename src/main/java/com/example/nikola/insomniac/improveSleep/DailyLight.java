package com.example.nikola.insomniac.improveSleep;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.ImproveSleep;
import com.example.nikola.insomniac.R;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DailyLight extends ImproveSleep {

    private static final String TAG = "SleepQuality";
    DatabaseHelper mDatabaseHelper;
    private Button btnAdd;
    private EditText editText;
    private Button dl;
    final Context context = this;


    public DailyLight() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dailylight);
        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        mDatabaseHelper = new DatabaseHelper(this);
        ImageButton dl = (ImageButton) findViewById(R.id.dl);

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

        dl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                // nl_info dialog
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dl_info);


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

    public void AddData(String newEntry) {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        try {
            mDatabaseHelper.addDailyLightData(newEntry, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            Log.d(TAG, "greska: " + e);
            toastMessage("Something went wrong");
        }
    }

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
