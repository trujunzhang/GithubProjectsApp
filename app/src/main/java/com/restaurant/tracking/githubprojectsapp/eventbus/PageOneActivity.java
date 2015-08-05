package com.restaurant.tracking.githubprojectsapp.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.restaurant.tracking.githubprojectsapp.R;

/**
 * Created by djzhang on 8/5/15.
 */
public class PageOneActivity extends TaskActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_pageone);

        this.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPageTwo();
            }
        });
    }

    private void showPageTwo() {
        Intent intent = new Intent(this, PageTwoActivity.class);

        this.startActivity(intent);
    }


}
