package com.restaurant.tracking.githubprojectsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.restaurant.tracking.githubprojectsapp.utils.LocationObserver;

/**
 * Created by djzhang on 7/29/15.
 */
public class SmartLocationActivity extends AppCompatActivity {
    private LocationObserver locationObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        locationObserver = new LocationObserver(this);

        locationObserver.startLocation();

    }
}
