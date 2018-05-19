package com.example.nikola.insomniac;

import android.app.Dialog;
import android.content.Context;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


import com.example.nikola.insomniac.mainTabs.TabImproveSleep;
import com.example.nikola.insomniac.mainTabs.TabLearnMore;
import com.example.nikola.insomniac.mainTabs.TabStatistic;
import com.example.nikola.insomniac.statistics.SectionsPageAdapter;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    final String PREFS_NAME = "MyPrefsFile";
    private ViewPager mViewPager;
    SectionsPageAdapter adapter;
    public int whichTab = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if (settings.getBoolean("my_first_time", true)) {

            // nl_info dialog
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.my_first_time);


            // set the nl_info dialog components - text, image and button
            TextView text1 = (TextView) dialog.findViewById(R.id.text1);
            TextView text2 = (TextView) dialog.findViewById(R.id.text2);
            TextView text3 = (TextView) dialog.findViewById(R.id.text3);


            Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
            // if button is clicked, close the nl_info dialog
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();

            settings.edit().putBoolean("my_first_time", false).commit();

        }

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.sleep_quality);
        tabLayout.getTabAt(1).setIcon(R.drawable.statistic);
        tabLayout.getTabAt(2).setIcon(R.drawable.learn_more);
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                whichTab = tab.getPosition();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


//        Button buttonLearnMore = (Button)findViewById(R.id.buttonLearnMore);
//        buttonLearnMore.setOnClickListener(
//                new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Intent myIntent = new Intent(MainActivity.this, LearnMore.class);
//                        myIntent.putExtra("key", value); //Optional parameters
//                        MainActivity.this.startActivity(myIntent);
//
//                    }
//                }
//        );
//
//        Button ImproveSleep = (Button)findViewById(R.id.ImproveSleep);
//        ImproveSleep.setOnClickListener(
//                new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Intent myIntent = new Intent(MainActivity.this, ImproveSleep.class);
//                        myIntent.putExtra("key", value); //Optional parameters
//                        MainActivity.this.startActivity(myIntent);
//
//                    }
//                });
//
//        Button trackProgress = (Button)findViewById(R.id.trackprogress);
//        trackProgress.setOnClickListener(
//                new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Intent myIntent = new Intent(MainActivity.this, TrackProgress.class);
//                        MainActivity.this.startActivity(myIntent);
//
//                    }
//                });
//
//        Button WorryBook = (Button)findViewById(R.id.WorryBook);
//        WorryBook.setOnClickListener(
//                new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Intent myIntent = new Intent(MainActivity.this, com.example.nikola.insomniac.worrybook.WorryBook.class);
//                        myIntent.putExtra("key", value); //Optional parameters
//                        MainActivity.this.startActivity(myIntent);
//                    }
//                }
//        );



    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabImproveSleep(), "");
        adapter.addFragment(new TabStatistic(), "");
        adapter.addFragment(new TabLearnMore(), "");
        viewPager.setAdapter(adapter);
    }

}