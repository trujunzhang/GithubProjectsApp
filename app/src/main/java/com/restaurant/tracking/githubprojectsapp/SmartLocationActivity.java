package com.restaurant.tracking.githubprojectsapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.restaurant.tracking.githubprojectsapp.utils.LocationObserver;

/**
 * Created by djzhang on 7/29/15.
 */
public class SmartLocationActivity extends LocationObserver {


    private TextView locationText;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_smart_location);

        locationText = (TextView) findViewById(R.id.location_text);
        button2 = (Button) findViewById(R.id.button2);

        this._locationText = locationText;
    }



}
