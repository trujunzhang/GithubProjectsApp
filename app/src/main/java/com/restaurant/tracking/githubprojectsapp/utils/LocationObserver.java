package com.restaurant.tracking.githubprojectsapp.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by djzhang on 7/29/15.
 */
public class LocationObserver extends AppCompatActivity {


    protected TextView _locationText;

    LocationManager mlocManager;
    LocationListener mlocListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mlocManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        this.mlocListener = new myLocationListerner();
    }


    @Override
    public void onResume() {
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 100, this.mlocListener);
        super.onResume();
    }

    @Override
    public void onPause() {
        mlocManager.removeUpdates(mlocListener);
        super.onPause();
    }


    private class myLocationListerner implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            showLocation(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }


    public String showLocation(Location location) {
        if (location != null) {
            final String text = String.format("Latitude %.6f, Longitude %.6f",
                    location.getLatitude(),
                    location.getLongitude());
            _locationText.setText(text);
            return text;
        }

        return "not found location";
    }

}
