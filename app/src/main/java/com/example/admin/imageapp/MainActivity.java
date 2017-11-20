package com.example.admin.imageapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Loux on 20-November-2017.
 */

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    activity_swipe activity_swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager)findViewById(R.id.viewPager);
        activity_swipe =new activity_swipe(this);
        viewPager.setAdapter(activity_swipe);
    }
}

