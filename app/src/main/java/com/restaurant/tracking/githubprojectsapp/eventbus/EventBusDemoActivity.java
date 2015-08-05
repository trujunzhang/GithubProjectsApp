package com.restaurant.tracking.githubprojectsapp.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.restaurant.tracking.githubprojectsapp.R;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * Created by djzhang on 8/5/15.
 */
public class EventBusDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_demo);
//        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
//        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void xxx(){

    }
}
