package com.example.nikola.insomniac.improveSleep;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
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

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import static android.R.attr.y;
import static com.example.nikola.insomniac.R.id.dl;


public class SleepQuality extends ImproveSleep {

    private static final String TAG = "SleepQuality";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText editText;

    private Button sq;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleepquality);
        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        mDatabaseHelper = new DatabaseHelper(this);
        ImageButton sq = (ImageButton) findViewById(R.id.sq);


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
    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
