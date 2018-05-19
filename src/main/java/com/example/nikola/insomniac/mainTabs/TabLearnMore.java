package com.example.nikola.insomniac.mainTabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.nikola.insomniac.R;
import com.example.nikola.insomniac.learnMore.LearnMoreImproveSleepQuality;
import com.example.nikola.insomniac.learnMore.LearnMoreInsomniac;
import com.example.nikola.insomniac.learnMore.LearnMoreSleep;
import com.example.nikola.insomniac.learnMore.LearnMoreStimulusControl;
import com.example.nikola.insomniac.learnMore.LearnMoreWorryBook;

public class TabLearnMore extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_learn_more,container,false);

        Button aboutinsomniac = (Button)view.findViewById(R.id.aboutinsomniac);
        aboutinsomniac.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                      Intent myIntent = new Intent(getActivity(), LearnMoreInsomniac.class);
                        startActivity(myIntent);
                    }
                }
        );

        Button introduction = (Button)view.findViewById(R.id.introduction);
        introduction.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                      Intent myIntent = new Intent(getActivity(), LearnMoreSleep.class);
                        startActivity(myIntent);
                    }
                }
        );

        Button stimuluscontrol = (Button)view.findViewById(R.id.stimuluscontrol);
        stimuluscontrol.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                       Intent myIntent = new Intent(getActivity(), LearnMoreStimulusControl.class);
                        startActivity(myIntent);
                    }
                }
        );

        Button learnmorechecklist = (Button)view.findViewById(R.id.learnmorechecklist);
        learnmorechecklist.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                      Intent myIntent = new Intent(getActivity(), LearnMoreImproveSleepQuality.class);
                        startActivity(myIntent);
                    }
                }
        );
        Button learnmoreworrybook = (Button)view.findViewById(R.id.learnmoreworrybook);
        learnmoreworrybook.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                       Intent myIntent = new Intent(getActivity(), LearnMoreWorryBook.class);
                        startActivity(myIntent);
                    }
                }
        );

        return view;

    }
}
