package com.example.nikola.insomniac.statistics;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.example.nikola.insomniac.R;

import java.util.ArrayList;


public class TrackProgress extends AppCompatActivity {
    private static final String TAG = "SleepQuality";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    SectionsPageAdapter adapter;
    public int whichTab = 0;
    public static String corelation = "";

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

        final Button sleepQ =  (Button) findViewById(R.id.SleepQuality);
        final Button phisicalA =  (Button) findViewById(R.id.PhisicalActivity);
        final Button Dailylight =  (Button) findViewById(R.id.Dailylight);
        final Button Nightlylight =  (Button) findViewById(R.id.Nightlylight);
        final Button Water =  (Button) findViewById(R.id.Water);
        final Button Food =  (Button) findViewById(R.id.Food);
        final Button Coffee =  (Button) findViewById(R.id.Coffee);
        final Button Bedroom =  (Button) findViewById(R.id.Bedroom);

        sleepQ.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            if (!arrayList.contains("SleepQuality")) {
                                arrayList.add("SleepQuality");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);

                            } else {
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
                                arrayList.add("PhysicalActivity");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);

                            } else {
                                arrayList.remove("PhysicalActivity");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            }
                        }else {
                            corelation = "PhysicalActivity";
                            Log.d(TAG, "corelation: " + corelation);

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
                                arrayList.add("DailyLight");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            } else {
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
                                arrayList.add("NightlyLight");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            } else {
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
                                arrayList.add("Water");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            } else {
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
//                            if(whichTab == 0) {
//
//                        if (!arrayList.contains("Food")) {
//                            arrayList.add("Food");
//                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
//                            mViewPager = (ViewPager) findViewById(R.id.container);
//                            setupViewPager(mViewPager);
//                        }else {
//
//                            arrayList.remove("Food");
//                            mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
//                            mViewPager = (ViewPager) findViewById(R.id.container);
//                            setupViewPager(mViewPager);
//                        }
//                            }else{
//                                corelation = "Food";
//                                setupViewPager(mViewPager);
//                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
//                                mViewPager = (ViewPager) findViewById(R.id.container);
//                                setupViewPager(mViewPager);
//                                mViewPager.setCurrentItem(1);
//                            }
                    }
                }
        );
        Coffee.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if(whichTab == 0) {
                            if (!arrayList.contains("Coffee")) {
                                arrayList.add("Coffee");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            } else {
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
                                arrayList.add("Bedroom");
                                mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                                mViewPager = (ViewPager) findViewById(R.id.container);
                                setupViewPager(mViewPager);
                            } else {
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
        adapter.addFragment(new Tab1Fragment(), "HISTORY");
        adapter.addFragment(new Tab2Fragment(), "CORRELATION");
        adapter.addFragment(new Tab3Fragment(), "REGRESSION");
        viewPager.setAdapter(adapter);
    }
}
