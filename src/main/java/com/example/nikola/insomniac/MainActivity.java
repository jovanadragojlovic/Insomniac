package com.example.nikola.insomniac;

import android.app.AlarmManager;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;


import com.example.nikola.insomniac.mainTabs.TabImproveSleep;
import com.example.nikola.insomniac.mainTabs.TabLearnMore;
import com.example.nikola.insomniac.mainTabs.TabGraphs;
import com.example.nikola.insomniac.noData.NoDataReceiver;
import com.example.nikola.insomniac.onFirstStart.OnBoardingActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    final String PREFS_NAME = "MyPrefsFile";
    private ViewPager mViewPager;
    SectionsPageAdapter adapter;
    public int whichTab = 0;
    private static final String TAG = "SleepQuality";
    static boolean doubleBack = false;


    //za no data
    private AlarmManager manager;
    private PendingIntent pendingIntent;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();


        //da keyboard ne iskoci odma on start
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //za no data
        Intent alarmIntent = new Intent (this, NoDataReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);

        startAlarm();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if (settings.getBoolean("my_first_time", true)) {

            Intent myIntent = new Intent(MainActivity.this, OnBoardingActivity.class);
            MainActivity.this.startActivity(myIntent);

            settings.edit().putBoolean("my_first_time", false).commit();

        }

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.sleep_quality);
        tabLayout.getTabAt(1).setIcon(R.drawable.statistic);
        tabLayout.getTabAt(2).setIcon(R.drawable.learn_more);
        tabLayout.setElevation(50);
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
    }

    //za NoData
    public void startAlarm() {
        Log.d(TAG, "nodata");
        manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 5);
        calendar.set(Calendar.SECOND, 0);
        int interval = 86400000;
        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), interval, pendingIntent);

    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabImproveSleep(), "");
        adapter.addFragment(new TabGraphs(), "");
        adapter.addFragment(new TabLearnMore(), "");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        if(this.doubleBack) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        this.doubleBack = true;
        Toast.makeText(this, "Press Back again to quit Insomniac", Toast.LENGTH_SHORT).show();
        super.onBackPressed();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBack=false;
            }
        }, 1500);
    }



}