package com.restaurant.tracking.githubprojectsapp;

import android.content.Context;
import android.location.Location;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesProvider;

/**
 * Created by djzhang on 7/29/15.
 */
public class LocationObserver implements OnLocationUpdatedListener {

    private LocationGooglePlayServicesProvider provider;

    private Context context;

    public LocationObserver(Context context) {
        this.context = context;
    }

    private void startLocation() {

        provider = new LocationGooglePlayServicesProvider();
//        provider.setCheckLocationSettings(true);

        SmartLocation smartLocation = new SmartLocation.Builder(this.context).logging(true).build();

        smartLocation.location().provider(provider).start(this);
//        smartLocation.activity().start(this);

    }

    @Override
    public void onLocationUpdated(Location location) {

    }
}
