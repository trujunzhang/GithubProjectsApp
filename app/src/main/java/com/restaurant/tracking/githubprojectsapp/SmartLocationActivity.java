package com.restaurant.tracking.githubprojectsapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.restaurant.tracking.githubprojectsapp.utils.LocationObserver;

/**
 * Created by djzhang on 7/29/15.
 */
public class SmartLocationActivity extends LocationObserver {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.startLocation();

    }
}
