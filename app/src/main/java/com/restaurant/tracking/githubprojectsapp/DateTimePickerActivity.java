package com.restaurant.tracking.githubprojectsapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Date;

/**
 * Created by djzhang on 7/26/15.
 */
public class DateTimePickerActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.context = this;

        this.setContentView(R.layout.activity_datepicker);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateTimePickerDialog dateTimePickerDialog = new DateTimePickerDialog(context, new DateTimePickerDialog.OnDateTimeSetListener() {
                    @Override
                    public void onDateTimeSet(DatePicker datePickerView, TimePicker timePickerView, int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minute) {

                    }
                }, new Date(), true);

                dateTimePickerDialog.show();
            }
        });
    }
}
