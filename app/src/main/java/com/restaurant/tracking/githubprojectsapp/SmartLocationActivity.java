package com.restaurant.tracking.githubprojectsapp;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;

/**
 * Created by djzhang on 7/29/15.
 */
public class SmartLocationActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SmartLocation.with(this).location().start(new OnLocationUpdatedListener() {
            @Override
            public void onLocationUpdated(Location location) {

            }
        });
    }
}
