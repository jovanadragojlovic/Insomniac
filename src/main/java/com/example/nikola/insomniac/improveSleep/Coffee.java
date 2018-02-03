package com.example.nikola.insomniac.improveSleep;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.ImproveSleep;
import com.example.nikola.insomniac.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Coffee extends ImproveSleep {
    private static final String TAG = "DailyLight";

    DatabaseHelper mDatabaseHelper;
    private ImageButton dodaj;
    private ImageButton oduzmi;
    private TextView pokazatelj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee);
        pokazatelj = (TextView) findViewById(R.id.pokazatelj);
        dodaj = (ImageButton) findViewById(R.id.dodaj);
        oduzmi = (ImageButton) findViewById(R.id.oduzmi);
        mDatabaseHelper = new DatabaseHelper(this);
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        String amountOnDate = mDatabaseHelper.getCoffeeByDate(date);
        pokazatelj.setText(amountOnDate != null ? amountOnDate : "0");

        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
            }
        });

        oduzmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubData();
            }
        });


    }



    public void AddData() {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        try {
            Integer vrednost = Integer.parseInt(pokazatelj.getText().toString()) + 1;
            mDatabaseHelper.addCoffeeData(vrednost.toString(), date);
            pokazatelj.setText(vrednost.toString());
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    public void SubData() {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        try {
            Integer vrednost = Integer.parseInt(pokazatelj.getText().toString()) - 1;
            if (vrednost >= 0) {
                mDatabaseHelper.addCoffeeData(vrednost.toString(), date);
                pokazatelj.setText(vrednost.toString());
            }
        } catch(Exception e) {
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
