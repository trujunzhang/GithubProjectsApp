package com.restaurant.tracking.githubprojectsapp.utils;

import android.content.Context;
import android.location.Location;

import com.google.android.gms.location.DetectedActivity;

import io.nlopez.smartlocation.OnActivityUpdatedListener;
import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesProvider;
import io.nlopez.smartlocation.utils.Logger;

/**
 * Created by djzhang on 7/29/15.
 */
public class LocationObserver implements OnLocationUpdatedListener, OnActivityUpdatedListener {

    private LocationGooglePlayServicesProvider provider;

    private Context context;

    public LocationObserver(Context context) {
        this.context = context;
    }

    public void startLocation() {

        provider = new LocationGooglePlayServicesProvider();
        provider.setCheckLocationSettings(true);

        SmartLocation smartLocation = new SmartLocation.Builder(this.context).logging(true).build();

        smartLocation.location().provider(provider).start(this);
        smartLocation.activity().start(this);
    }


    public void stopLocation() {
        SmartLocation.with(this.context).location().stop();

        SmartLocation.with(this.context).activity().stop();
    }


    @Override
    public void onLocationUpdated(Location location) {
        this.showLocation(location);
    }

    @Override
    public void onActivityUpdated(DetectedActivity detectedActivity) {

    }


    private void showLocation(Location location) {
        if (location != null) {
            final String text = String.format("Latitude %.6f, Longitude %.6f",
                    location.getLatitude(),
                    location.getLongitude());


        } else {
//            locationText.setText("Null location");
        }
    }

}
