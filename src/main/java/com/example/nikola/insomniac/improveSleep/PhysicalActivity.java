package com.example.nikola.insomniac.improveSleep;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.ImproveSleep;
import com.example.nikola.insomniac.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PhysicalActivity extends ImproveSleep {

    private static final String TAG = "DailyLight";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physicalactivity);
        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        mDatabaseHelper = new DatabaseHelper(this);

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

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
