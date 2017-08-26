package com.example.nikola.insomniac.statistics;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.nikola.insomniac.R;

import java.util.ArrayList;


public class TrackProgress extends AppCompatActivity {
    private static final String TAG = "SleepQuality";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    public boolean cklicked = true;
    SectionsPageAdapter adapter;
    public int whichTab = 0;
    public static String corelation = "Water";

    public static ArrayList<String> arrayList = new ArrayList<String>();
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackprogress);
        Log.d(TAG, "onCreate: Starting.");
        arrayList = new ArrayList<String>();

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());


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

        final Button btn = (Button) findViewById(R.id.buttonDropUp);
        final Button sleepQ =  (Button) findViewById(R.id.SleepQuality);
        final Button phisicalA =  (Button) findViewById(R.id.PhisicalActivity);
        final Button Dailylight =  (Button) findViewById(R.id.Dailylight);
        final Button Nightlylight =  (Button) findViewById(R.id.Nightlylight);
        final Button Water =  (Button) findViewById(R.id.Water);
        final Button Food =  (Button) findViewById(R.id.Food);
        final Button Coffee =  (Button) findViewById(R.id.Coffee);
        final Button Bedroom =  (Button) findViewById(R.id.Bedroom);

        sleepQ.setAlpha(0);
        phisicalA.setAlpha(0);
        Nightlylight.setAlpha(0);
        Dailylight.setAlpha(0);
        Water.setAlpha(0);
        Food.setAlpha(0);
        Coffee.setAlpha(0);
        Bedroom.setAlpha(0);
        btn.setText("SHOW");


        btn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(cklicked) {
                            btn.animate().translationYBy(-600)
                                    .setDuration(700).start();
                            Bedroom.animate().setStartDelay(0).alpha(1).setDuration(200).start();
                            Nightlylight.animate().setStartDelay(0).alpha(1).setDuration(200).start();
                            Coffee.animate().setStartDelay(200).alpha(1).setDuration(200).start();
                            Dailylight.animate().setStartDelay(200).alpha(1).setDuration(200).start();
                            Food.animate().setStartDelay(400).alpha(1).setDuration(200).start();
                            phisicalA.animate().setStartDelay(400).alpha(1).setDuration(200).start();
                            Water.animate().setStartDelay(600).alpha(1).setDuration(200).start();
                            sleepQ.animate().setStartDelay(600).alpha(1).setDuration(200).start();
                            btn.setText("HIDE");
                            cklicked = false;
                        }else {
                            Bedroom.animate().setStartDelay(600).alpha(0).setDuration(200).start();
                            Nightlylight.animate().setStartDelay(600).alpha(0).setDuration(200).start();
                            Coffee.animate().setStartDelay(400).alpha(0).setDuration(200).start();
                            Dailylight.animate().setStartDelay(400).alpha(0).setDuration(200).start();
                            Food.animate().setStartDelay(200).alpha(0).setDuration(200).start();
                            phisicalA.animate().setStartDelay(200).alpha(0).setDuration(200).start();
                            Water.animate().setStartDelay(0).alpha(0).setDuration(200).start();
                            sleepQ.animate().setStartDelay(0).alpha(0).setDuration(200).start();

                            btn.animate().translationYBy(600)
                                    .setDuration(700).start();
                            btn.setText("SHOW");

                            cklicked = true;
                        }


                    }
                });
        sleepQ.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            if (!arrayList.contains("SleepQuality")) {
                                sleepQ.setBackgroundColor(Color.parseColor("#3cffffff"));
                                arrayList.add("SleepQuality");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);

                            } else {
                                sleepQ.setBackgroundColor(Color.parseColor("#21ffffff"));
                                arrayList.remove("SleepQuality");
                                setupViewPager(mViewPager);
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);

                            }
                        }else {
                            corelation = "SleepQuality";
                            setupViewPager(mViewPager);
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);
                            mViewPager.setCurrentItem(1);
                        }
                    }
                }
        );

        phisicalA.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            if (!arrayList.contains("PhysicalActivity")) {
                                phisicalA.setBackgroundColor(Color.parseColor("#3cffffff"));
                                arrayList.add("PhysicalActivity");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);

                            } else {
                                phisicalA.setBackgroundColor(Color.parseColor("#21ffffff"));
                                arrayList.remove("PhysicalActivity");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            }
                        }else {
                            corelation = "PhysicalActivity";
                            setupViewPager(mViewPager);
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);
                            mViewPager.setCurrentItem(1);
                        }
                    }
                }
        );

        Dailylight.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            if (!arrayList.contains("DailyLight")) {
                                Dailylight.setBackgroundColor(Color.parseColor("#3cffffff"));
                                arrayList.add("DailyLight");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            } else {
                                Dailylight.setBackgroundColor(Color.parseColor("#21ffffff"));
                                arrayList.remove("DailyLight");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            }
                        }else {
                            corelation = "DailyLight";
                            setupViewPager(mViewPager);
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);
                            mViewPager.setCurrentItem(1);
                        }
                    }
                }
        );
        Nightlylight.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            if (!arrayList.contains("NightlyLight")) {
                                Nightlylight.setBackgroundColor(Color.parseColor("#3cffffff"));
                                arrayList.add("NightlyLight");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            } else {
                                Nightlylight.setBackgroundColor(Color.parseColor("#21ffffff"));
                                arrayList.remove("NightlyLight");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            }
                        }else {
                            corelation = "NightlyLight";
                            setupViewPager(mViewPager);
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);
                            mViewPager.setCurrentItem(1);
                        }
                    }
                }
        );
        Water.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            if (!arrayList.contains("Water")) {
                                Water.setBackgroundColor(Color.parseColor("#3cffffff"));
                                arrayList.add("Water");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            } else {
                                Water.setBackgroundColor(Color.parseColor("#21ffffff"));
                                arrayList.remove("Water");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            }
                        }else{
                            corelation = "Water";
                            setupViewPager(mViewPager);
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);
                            mViewPager.setCurrentItem(1);
                        }
                    }
                }
        );
        Food.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                            if(whichTab == 0) {

//                        if (!arrayList.contains("Food")) {
//                            Food.setBackgroundColor(Color.parseColor("#3cffffff"));
//                            arrayList.add("Food");
//                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
//                            mViewPager = (ViewPager) findViewById(R.id.container);
//                            setupViewPager(mViewPager);
//                        }else {
//
//                            Food.setBackgroundColor(Color.parseColor("#21ffffff"));
//                            arrayList.remove("Food");
//                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
//                            mViewPager = (ViewPager) findViewById(R.id.container);
//                            setupViewPager(mViewPager);
//                        }
                            }else{
                                corelation = "Food";
                                setupViewPager(mViewPager);
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                                mViewPager.setCurrentItem(1);
                            }
                    }
                }
        );
        Coffee.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            if (!arrayList.contains("Coffee")) {
                                Coffee.setBackgroundColor(Color.parseColor("#3cffffff"));
                                arrayList.add("Coffee");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            } else {
                                Coffee.setBackgroundColor(Color.parseColor("#21ffffff"));
                                arrayList.remove("Coffee");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            }
                        }else{
                            corelation = "Coffee";
                            setupViewPager(mViewPager);
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);
                            mViewPager.setCurrentItem(1);
                        }
                    }
                }
        );
        Bedroom.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            if (!arrayList.contains("Bedroom")) {
                                Bedroom.setBackgroundColor(Color.parseColor("#3cffffff"));
                                arrayList.add("Bedroom");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            } else {
                                Bedroom.setBackgroundColor(Color.parseColor("#21ffffff"));
                                arrayList.remove("Bedroom");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            }
                        }else{
                            corelation = "Bedroom";
                            setupViewPager(mViewPager);
                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                            mViewPager = (ViewPager) findViewById(R.id.container);
                            setupViewPager(mViewPager);
                            mViewPager.setCurrentItem(1);
                        }
                    }
                }
        );

    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "TAB1");
        adapter.addFragment(new Tab2Fragment(), "TAB2");
        viewPager.setAdapter(adapter);
    }

    public ArrayList<String> getCheckedVariables(){
        return arrayList;
    }
}
