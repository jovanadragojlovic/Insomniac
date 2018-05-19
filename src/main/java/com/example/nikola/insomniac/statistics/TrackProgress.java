package com.example.nikola.insomniac.statistics;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.example.nikola.insomniac.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TrackProgress extends AppCompatActivity {
    private static final String TAG = "SleepQuality";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    SectionsPageAdapter adapter;
    public int whichTab = 0;
    public static String corelation = "";
    public static String clickedVar;
    int position;
    Map<String, Button> map;
    final Context context = this;
    final String PREFS_NAME = "MyPrefsFile2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackprogress);



        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if (settings.getBoolean("my_first_trackprogress", true)) {

            // nl_info dialog
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.my_first_trackprogress);


            // set the nl_info dialog components - text, image and button
            TextView text1 = (TextView) dialog.findViewById(R.id.text1);



            Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
            // if button is clicked, close the nl_info dialog
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();

            settings.edit().putBoolean("my_first_trackprogress", false).commit();

        }




        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        clickedVar = "SleepQuality";

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

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

        final Button sleepQ =  (Button) findViewById(R.id.SleepQuality);
        final Button phisicalA =  (Button) findViewById(R.id.PhisicalActivity);
        final Button Dailylight =  (Button) findViewById(R.id.Dailylight);
        final Button Nightlylight =  (Button) findViewById(R.id.Nightlylight);
        final Button Coffee =  (Button) findViewById(R.id.Coffee);
        final Button Bedroom =  (Button) findViewById(R.id.Bedroom);

        map = new HashMap<>();
        map.put("SleepQuality", sleepQ);
        map.put("DailyLight", Dailylight);
        map.put("NightlyLight", Nightlylight);
        map.put("PhysicalActivity",phisicalA);
        map.put("Coffee", Coffee);
        map.put("Bedroom", Bedroom);

        sleepQ.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            map.get(clickedVar).setBackgroundColor(Color.parseColor("#21ffffff"));
                            sleepQ.setBackgroundColor(Color.parseColor("#3cffffff"));
                            clickedVar = "SleepQuality";
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);

                        }
                    }
                }
        );

        phisicalA.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            map.get(clickedVar).setBackgroundColor(Color.parseColor("#21ffffff"));
                            phisicalA.setBackgroundColor(Color.parseColor("#3cffffff"));
                            clickedVar = "PhysicalActivity";
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);

                        }
                    }
                }
        );

        Dailylight.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            map.get(clickedVar).setBackgroundColor(Color.parseColor("#21ffffff"));
                            Dailylight.setBackgroundColor(Color.parseColor("#3cffffff"));
                            clickedVar = "DailyLight";
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);
                        }
                    }
                }

        );
        Nightlylight.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            map.get(clickedVar).setBackgroundColor(Color.parseColor("#21ffffff"));
                            Nightlylight.setBackgroundColor(Color.parseColor("#3cffffff"));
                            clickedVar = "NightlyLight";
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);
                        }
                    }
                }

        );

        Coffee.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            map.get(clickedVar).setBackgroundColor(Color.parseColor("#21ffffff"));
                            Coffee.setBackgroundColor(Color.parseColor("#3cffffff"));
                            clickedVar = "Coffee";
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);
                        }
                    }
                }

        );
        Bedroom.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            map.get(clickedVar).setBackgroundColor(Color.parseColor("#21ffffff"));
                            Bedroom.setBackgroundColor(Color.parseColor("#3cffffff"));
                            clickedVar = "Bedroom";
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);
                        }
                    }
                }

        );

    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "Track progress");
        viewPager.setAdapter(adapter);
    }
}














