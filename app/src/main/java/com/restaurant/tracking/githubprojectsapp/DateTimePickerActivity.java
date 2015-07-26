package com.restaurant.tracking.githubprojectsapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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


        getNextHourDate();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateTimePickerDialog dateTimePickerDialog = new DateTimePickerDialog(context, new DateTimePickerDialog.OnDateTimeSetListener() {
                    @Override
                    public void onDateTimeSet(DatePicker datePickerView, TimePicker timePickerView, int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minute) {
                        GregorianCalendar calendar = new GregorianCalendar(year,monthOfYear,dayOfMonth,hourOfDay,minute);
                        Date endDate = calendar.getTime();



                    }
                }, new Date(), true);

                dateTimePickerDialog.show();
            }
        });
    }

    private void getNextHourDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.HOUR, 1);
        Date d = c.getTime();
    }
}
