package com.example.nikola.insomniac.mainTabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nikola.insomniac.DatabaseHelper;
import com.example.nikola.insomniac.R;
import com.example.nikola.insomniac.improveSleep.Bedroom;
import com.example.nikola.insomniac.improveSleep.Coffee;
import com.example.nikola.insomniac.improveSleep.DailyLight;
import com.example.nikola.insomniac.improveSleep.NightlyLight;
import com.example.nikola.insomniac.improveSleep.NightlyLightService;
import com.example.nikola.insomniac.improveSleep.PhysicalActivity;
import com.example.nikola.insomniac.improveSleep.SleepQuality;
import com.example.nikola.insomniac.improveSleep.StepsService;
import com.example.nikola.insomniac.worrybook.WorryBook;


public class TabImproveSleep extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_improve_sleep,container,false);

        Button sleepquality = (Button)view.findViewById(R.id.sleepquality);
        sleepquality.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getActivity(), SleepQuality.class);
                        startActivity(myIntent);
                    }
                }
        );

        Button physicalactivity = (Button)view.findViewById(R.id.physicalactivity);
        physicalactivity.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getActivity(), PhysicalActivity.class);
                        startActivity(myIntent);

                    }
                }
        );

        Button dailylight = (Button)view.findViewById(R.id.dailylight);
        dailylight.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getActivity(), DailyLight.class);
                        startActivity(myIntent);
                    }
                }
        );

        Button nightlylight = (Button)view.findViewById(R.id.nightlylight);
        nightlylight.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getActivity(), NightlyLight.class);
                        startActivity(myIntent);
                    }
                }
        );


        Button coffee = (Button)view.findViewById(R.id.coffee);
        coffee.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getActivity(), Coffee.class);
                       startActivity(myIntent);
                    }
                }
        );

        Button bedroom = (Button)view.findViewById(R.id.bedroom);
        bedroom.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getActivity(), Bedroom.class);
                        startActivity(myIntent);
                    }
                }
        );

        Button worrybook = (Button)view.findViewById(R.id.worrybook);
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
}
