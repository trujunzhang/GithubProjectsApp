package com.restaurant.tracking.githubprojectsapp.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.restaurant.tracking.githubprojectsapp.eventbus.events.PostedModelEvent;
import com.restaurant.tracking.githubprojectsapp.eventbus.models.EventPageInfo;

import de.greenrobot.event.EventBus;

/**
 * Created by djzhang on 8/5/15.
 */
public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {
            EventBus.getDefault().unregister(this);
        } catch (Throwable t) {
            //this may crash if registration did not go through. just be safe
        }

    }

    @SuppressWarnings("UnusedDeclaration")
    public void onEventMainThread(PostedModelEvent ignored) {
        //we could just add this to top or replace element instead of refreshing whole list
        EventPageInfo model = ignored.getModel();
        String displayName = model.displayName;
    }
}
