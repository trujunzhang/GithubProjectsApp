package com.restaurant.tracking.githubprojectsapp;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.restaurant.tracking.githubprojectsapp.utils.LocationObserver;

import io.nlopez.smartlocation.SmartLocation;
import pl.charmas.android.reactivelocation.ReactiveLocationProvider;
import rx.functions.Action1;

/**
 * Created by djzhang on 7/29/15.
 */
public class SmartLocationActivity extends AppCompatActivity {


    private TextView locationText;
    private Button button2;

    LocationManager mlocManager;
    LocationListener mlocListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_smart_location);

        locationText = (TextView) findViewById(R.id.location_text);
        button2 = (Button) findViewById(R.id.button2);

//        this.startLocation();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showLast();
            }
        });

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


    public String showLocation(Location location) {
        if (location != null) {
            final String text = String.format("Latitude %.6f, Longitude %.6f",
                    location.getLatitude(),
                    location.getLongitude());
            locationText.setText(text);
            return text;
        }

        return "not found location";
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
}
