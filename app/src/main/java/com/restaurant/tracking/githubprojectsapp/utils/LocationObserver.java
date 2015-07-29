package com.restaurant.tracking.githubprojectsapp.utils;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.location.DetectedActivity;

import io.nlopez.smartlocation.OnActivityUpdatedListener;
import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesProvider;
import io.nlopez.smartlocation.utils.Logger;

/**
 * Created by djzhang on 7/29/15.
 */
public class LocationObserver extends AppCompatActivity implements OnLocationUpdatedListener, OnActivityUpdatedListener {

    private LocationGooglePlayServicesProvider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void startLocation() {

        provider = new LocationGooglePlayServicesProvider();
        provider.setCheckLocationSettings(true);

        SmartLocation smartLocation = new SmartLocation.Builder(this).logging(true).build();

        smartLocation.location().provider(provider).start(this);
        smartLocation.activity().start(this);
    }


    public void stopLocation() {
        SmartLocation.with(this).location().stop();

        SmartLocation.with(this).activity().stop();
    }


    @Override
    public void onLocationUpdated(Location location) {
//        this.showLocation(location);
    }

    @Override
    public void onActivityUpdated(DetectedActivity detectedActivity) {

    }




}
