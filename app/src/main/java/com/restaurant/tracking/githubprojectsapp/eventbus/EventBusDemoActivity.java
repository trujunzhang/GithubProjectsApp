package com.restaurant.tracking.githubprojectsapp.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.restaurant.tracking.githubprojectsapp.R;
import com.restaurant.tracking.githubprojectsapp.eventbus.models.EventPageInfo;

import de.greenrobot.event.EventBus;


public class EventBusDemoActivity extends AppCompatActivity {
    private TextView infoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_event_bus_demo);

        // Register
        EventBus.getDefault().register(this);

        this.infoView = (TextView) findViewById(R.id.textView2);
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new EventPageInfo("djzhang", "wanghao's post"));
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        // Unregister
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(EventPageInfo item) {
        if (item != null) {
            this.infoView.setText(item.displayName + " " + item.content);
        }
    }


}
