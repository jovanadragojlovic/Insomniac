package com.example.nikola.insomniac.mainTabs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.R;
import com.example.nikola.insomniac.worrybook.WorryBook;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class TabImproveSleep extends Fragment {

    //in common for all
    DatabaseHelper mDatabaseHelper;
    String date;

    //SleepQuality
    RatingBar simpleRatingBar;
    TextView textView2;
    int SRB;

    //SleepDuration
    SeekBar simpleSeekBar;
    TextView textView4;
    String SSB;
    int savedvalue;


    //PhysicalActivity
    private EditText input_pa;
    private TextView textView1;
    private TextView textView3;
    Spinner spinne_pa;

    //DailyLight
    private EditText input_dl;
    TextView resultsdailylight;

    //NightlyLight
    private EditText input_nl;
    TextView resultsnightlylight;

    //Coffee
    private ImageButton dodaj;
    private ImageButton oduzmi;
    private TextView pokazatelj;

    //Bedroom
    RatingBar simpleRatingBar2;
    private TextView textView5;
    int SRB2;

    //WorryBook
    Button worrybook;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_improvesleep,container,false);


        //in common for all
        mDatabaseHelper = new DatabaseHelper(getActivity());
        date = new SimpleDateFormat("MM/dd/yy").format(new Date());

        //SleepQuality
        simpleRatingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        textView2 = (TextView) view.findViewById(R.id.text2_2);


        //SleepDuration
        simpleSeekBar = (SeekBar) view.findViewById(R.id.seekBar);
        simpleSeekBar.setMax(600);
        textView4 = (TextView) view.findViewById(R.id.text4_4);

        //PhysicalActivity
        input_pa = (EditText) view.findViewById(R.id.input_pa);
        textView3 = (TextView) view.findViewById(R.id.text6);
        spinne_pa = (Spinner) view.findViewById(R.id.spinner_pa);

        //DailyLight
        input_dl = (EditText) view.findViewById(R.id.input_dl);
        resultsdailylight = (TextView)view.findViewById(R.id.resultsdailylightjava);


        //NightlyLight
        input_nl = (EditText) view.findViewById(R.id.input_nl);
        resultsnightlylight = (TextView)view.findViewById(R.id.resultsnightlylightjava);

        //Coffee
        pokazatelj = (TextView) view.findViewById(R.id.pokazatelj);
        dodaj = (ImageButton) view.findViewById(R.id.dodaj);
        oduzmi = (ImageButton) view.findViewById(R.id.oduzmi);
        String amountOnDate = mDatabaseHelper.getCoffeeByDate(date);
        pokazatelj.setText(amountOnDate != null ? amountOnDate : "0");

        //Bedroom
        simpleRatingBar2 = (RatingBar) view.findViewById(R.id.ratingBar2);
        textView5 = (TextView) view.findViewById(R.id.text16_1);

        //WorryBook
        Button worrybook = (Button)view.findViewById(R.id.text17);


        if (mDatabaseHelper.getSleepQualityByDate(date) !=null) {
            String privremeno = mDatabaseHelper.getSleepQualityByDate(date);
            SRB = Integer.parseInt(privremeno);
            simpleRatingBar.setRating(SRB);
        }

        //SleepQuality

        simpleRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                boolean pali = b;
                if(b) {
                    if (v <=1) {
                        textView2.setText("Poor");
                        SRB = 1;
                        AddData(String.valueOf(SRB));
                    }
                    else if (v > 1 && v <=2) {
                        textView2.setText("Fair");
                        SRB = 2;
                        AddData(String.valueOf(SRB));
                    }
                    else if (v > 2 && v <=3) {
                        textView2.setText("Good");
                        SRB = 3;
                        AddData(String.valueOf(SRB));
                    }
                    else if (v >3 && v <=4) {
                        textView2.setText("Very good");
                        SRB = 4;
                        AddData(String.valueOf(SRB));
                    }
                    else {
                        textView2.setText("Excellent");
                        SRB = 5;
                        AddData(String.valueOf(SRB));
                    }
                }
            }
        } );




        //SleepDuration

        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

             int progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                if(b) {
                    progressChangedValue = i;

                    long minutes = (long) progressChangedValue;

                    long hours = TimeUnit.MINUTES.toHours(minutes);

                    minutes -= TimeUnit.HOURS.toMinutes(hours);

                    textView4.setText(String.valueOf(hours) + " hours " + String.valueOf(minutes) + " minutes ");

                    SSB = String.valueOf(progressChangedValue);

                    AddData2(SSB);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        if (mDatabaseHelper.getSleepingTimeByDate(date) !=null) {
            String privremeno2 = mDatabaseHelper.getSleepingTimeByDate(date);
            savedvalue = Integer.parseInt(privremeno2);
            simpleSeekBar.setProgress(savedvalue);
        }

        //PhysicalActivity

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_pa_values, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinne_pa.setAdapter(adapter);


        if (mDatabaseHelper.getSportByDate(date) !=null) {
            double doubleseconds = Double.parseDouble(mDatabaseHelper.getSportByDate(date));

            long seconds = (long) doubleseconds;

            long hours = TimeUnit.SECONDS.toHours(seconds);

            seconds -= TimeUnit.HOURS.toSeconds(hours);
            long minutes = TimeUnit.SECONDS.toMinutes(seconds);


            input_pa.setHintTextColor(Color.BLACK);
            input_pa.setHint(String.valueOf(hours) + "h " + String.valueOf(minutes) + "min ");
        }
        else {
            input_pa.setHintTextColor(Color.BLACK);
            input_pa.setHint("0h 0min");
        }

        input_pa.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    String newEntry = input_pa.getText().toString();
                    long minutesFromEntry = Long.parseLong(newEntry);
                    long sec = TimeUnit.MINUTES.toSeconds(minutesFromEntry);
                    AddSport(String.valueOf(sec));

                    double doubleseconds = Double.parseDouble(mDatabaseHelper.getSportByDate(date));
                    long seconds = (long) doubleseconds;
                    long hours = TimeUnit.SECONDS.toHours(seconds);
                    seconds -= TimeUnit.HOURS.toSeconds(hours);
                    long minutes = TimeUnit.SECONDS.toMinutes(seconds);

                    input_pa.setText("");
                    input_pa.setHintTextColor(Color.BLACK);
                    input_pa.setHint(String.valueOf(hours) + "h " + String.valueOf(minutes) + "min ");

                    InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(input_pa.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    return true;


                }
                return false;
            }
        });

        input_pa.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    input_pa.setHint("");
                else {
                    double doubleseconds = Double.parseDouble(mDatabaseHelper.getSportByDate(date));

                    long seconds = (long) doubleseconds;

                    long hours = TimeUnit.SECONDS.toHours(seconds);

                    seconds -= TimeUnit.HOURS.toSeconds(hours);
                    long minutes = TimeUnit.SECONDS.toMinutes(seconds);


                    input_pa.setHintTextColor(Color.BLACK);
                    input_pa.setHint(String.valueOf(hours) + "h " + String.valueOf(minutes) + "min ");

                    input_pa.setCursorVisible(false);

                }
            }
        });




        //DailyLight
        //Da ako ima nesto u bazi, stavi to u Hint

        if (mDatabaseHelper.getDailyLightByDate(date) != null) {

            double doubleseconds = Double.parseDouble(mDatabaseHelper.getDailyLightByDate(date));

            long seconds = (long) doubleseconds;

            long hours = TimeUnit.SECONDS.toHours(seconds);

            seconds -= TimeUnit.HOURS.toSeconds(hours);

            long minutes = TimeUnit.SECONDS.toMinutes(seconds);

            input_dl.setHintTextColor(Color.BLACK);
            input_dl.setHint("" + String.valueOf(hours) + "h " + String.valueOf(minutes) + "min ");
        }
        else {
            input_dl.setHintTextColor(Color.BLACK);
            input_dl.setHint(" 0h 0min");
        }


        //da na pritisak "done" doda vrednost u bazu i updatuje Hint
        input_dl.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    String newEntry = input_dl.getText().toString();
                    long minutesFromEntry = Long.parseLong(newEntry);
                    long sec = TimeUnit.MINUTES.toSeconds(minutesFromEntry);
                    AddData3(String.valueOf(sec));

                    double doubleseconds = Double.parseDouble(mDatabaseHelper.getDailyLightByDate(date));
                    long seconds = (long) doubleseconds;
                    long hours = TimeUnit.SECONDS.toHours(seconds);
                    seconds -= TimeUnit.HOURS.toSeconds(hours);
                    long minutes = TimeUnit.SECONDS.toMinutes(seconds);

                    input_dl.setText("");
                    input_dl.setHintTextColor(Color.BLACK);
                    input_dl.setHint("" + String.valueOf(hours) + "h " + String.valueOf(minutes) + "min ");

                    //da skloni tastaturu posle pritiska na "Done"
                    InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(input_dl.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                    return true;
                }
                return false;
            }
        });

        //Da skloni vrednost Hinta kada user pritisne na edit text
        input_dl.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    input_dl.setHint("");
//                else {
//                    double doubleseconds = Double.parseDouble(mDatabaseHelper.getDailyLightByDate(date));
//
//                    long seconds = (long) doubleseconds;
//
//                    long hours = TimeUnit.SECONDS.toHours(seconds);
//
//                    seconds -= TimeUnit.HOURS.toSeconds(hours);
//
//                    long minutes = TimeUnit.SECONDS.toMinutes(seconds);
//
//                    input_dl.setHintTextColor(Color.BLACK);
//                    input_dl.setHint("" + String.valueOf(hours) + "h " + String.valueOf(minutes) + "min ");
//
//                    //da skloni cursor kad klikne done
//                    input_dl.setCursorVisible(false);
//                }
            }
        });



        //NightlyLight

        if (mDatabaseHelper.getNightlyLightByDate(date)!= null) {

            double doubleseconds = Double.parseDouble(mDatabaseHelper.getNightlyLightByDate(date));

            long seconds = (long)doubleseconds;

            long hours = TimeUnit.SECONDS.toHours(seconds);

            seconds -= TimeUnit.HOURS.toSeconds(hours);

            long minutes = TimeUnit.SECONDS.toMinutes(seconds);

            input_nl.setHintTextColor(Color.BLACK);
            input_nl.setHint(String.valueOf(hours) + "h " + String.valueOf(minutes) + "min ");
        }
        else {
            input_nl.setHintTextColor(Color.BLACK);
            input_nl.setHint("0h 0min");
        }


        input_nl.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    String newEntry = input_nl.getText().toString();
                    long minutesFromEntry = Long.parseLong(newEntry);
                    long sec = TimeUnit.MINUTES.toSeconds(minutesFromEntry);
                    AddData4(String.valueOf(sec));

                    double doubleseconds = Double.parseDouble(mDatabaseHelper.getNightlyLightByDate(date));
                    long seconds = (long) doubleseconds;
                    long hours = TimeUnit.SECONDS.toHours(seconds);
                    seconds -= TimeUnit.HOURS.toSeconds(hours);
                    long minutes = TimeUnit.SECONDS.toMinutes(seconds);

                    input_nl.setText("");
                    input_nl.setHintTextColor(Color.BLACK);
                    input_nl.setHint(String.valueOf(hours) + "h " + String.valueOf(minutes) + "min ");

                    InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(input_nl.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                    input_nl.setCursorVisible(false);

                    return true;
                }
                return false;
            }
        });

        input_nl.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    input_nl.setHint("");
            }
        });



        //Coffee

        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData5();
            }
        });

        oduzmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubData();
            }
        });

        //Bedroom

        simpleRatingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                if(b) {
                    if (v <=1) {
                        textView5.setText("Poor");
                        SRB2 = 1;
                        AddHumidity(String.valueOf(SRB2));
                    }
                    else if (v > 1 && v <=2) {
                        textView5.setText("Fair");
                        SRB2 = 2;
                        AddHumidity(String.valueOf(SRB2));
                    }
                    else if (v > 2 && v <=3) {
                        textView5.setText("Good");
                        SRB2 = 3;
                        AddHumidity(String.valueOf(SRB2));
                    }
                    else if (v >3 && v <=4) {
                        textView5.setText("Very good");
                        SRB2 = 4;
                        AddHumidity(String.valueOf(SRB2));
                    }
                    else {
                        textView5.setText("Excellent");
                        SRB2 = 5;
                        AddHumidity(String.valueOf(SRB2));
                    }
                }
            }
        } );

//        btnSave6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String Bedroom = String.valueOf(SRB2);
//
//                if (SRB2 != 0) {
//                    AddHumidity(Bedroom);
//                }
//
//            }
//        });

        if (mDatabaseHelper.getHumidityByDate(date) !=null) {
            String privremeno3 = mDatabaseHelper.getHumidityByDate(date);
            SRB2 = Integer.parseInt(privremeno3);
            simpleRatingBar2.setRating(SRB2);
        }

        //WorryBook

        worrybook.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getActivity(), WorryBook.class);
                        startActivity(myIntent);
                    }
                }
        );

        return view;

    }

    public void AddData(String newEntry) {
        try {
            mDatabaseHelper.addSleepQualityData(newEntry, date);
            toastMessage("Data Successfully Inserted! SQ");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    public void AddData2(String newEntry) {
        try {
            mDatabaseHelper.addSleepingTime(newEntry, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    public void AddSport(String newEntry) {
        try {
            mDatabaseHelper.addPhysicalActivitySport(newEntry, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    public void AddData3(String newEntry) {
        String date = new SimpleDateFormat("MM/dd/yy").format(new Date());
        try {
            mDatabaseHelper.addDailyLightData(newEntry, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    public void AddData4(String newEntry) {
        String date = new SimpleDateFormat("MM/dd/yy").format(new Date());
        try {
            mDatabaseHelper.addNightlyLightData(newEntry, date);
            toastMessage("Data Successfully Inserted!");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    public void AddData5() {
        String date = new SimpleDateFormat("MM/dd/yy").format(new Date());
        try {
            Integer vrednost = Integer.parseInt(pokazatelj.getText().toString()) + 1;
            mDatabaseHelper.addCoffeeData(vrednost.toString(), date);
            pokazatelj.setText(vrednost.toString());
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    public void SubData() {
        String date = new SimpleDateFormat("MM/dd/yy").format(new Date());
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

    public void AddHumidity(String newEntry) {
        String date = new SimpleDateFormat("MM/dd/yy").format(new Date());
        try {
            mDatabaseHelper.addBedroomHumidity(newEntry, date);
            toastMessage("Data Successfully Inserted! bedroom");
        } catch(Exception e) {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(getActivity(),message, Toast.LENGTH_SHORT).show();
    }
}
