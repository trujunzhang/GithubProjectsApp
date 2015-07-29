package com.restaurant.tracking.githubprojectsapp;

import android.content.Context;
import android.location.Location;
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
public class SmartLocationActivity extends LocationObserver {


    private TextView locationText;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_smart_location);

        locationText = (TextView) findViewById(R.id.location_text);
        button2 = (Button) findViewById(R.id.button2);

//        this.startLocation();

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });


        ReactiveLocationProvider locationProvider = new ReactiveLocationProvider(this);
        locationProvider.getLastKnownLocation()
                .subscribe(new Action1<Location>() {
                    @Override
                    public void call(Location location) {
                        String text = showLocation(location);
                        locationText.setText(text);
                    }
                });
    }


}
