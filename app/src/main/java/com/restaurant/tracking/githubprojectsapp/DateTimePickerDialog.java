package com.restaurant.tracking.githubprojectsapp;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;


public class DateTimePickerDialog extends AlertDialog implements OnClickListener, OnDateChangedListener, OnTimeChangedListener {

    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static final String DAY = "day";
    private static final String HOUR_OF_DAY = "hourOfDay";
    private static final String MINUTE = "minute";

    private final DatePicker mDatePicker;
    private final TimePicker mTimePicker;
    private final OnDateTimeSetListener mDateTimeCallBack;
    private final Calendar mCalendar;
    private final java.text.DateFormat mTitleDateFormat;

    private int mInitialYear;
    private int mInitialMonth;
    private int mInitialDay;
    private int mInitialHour;
    private int mInitialMinute;

    /**
     * The callback used to indicate the user is done filling in the date.
     */
    public interface OnDateTimeSetListener {

        void onDateTimeSet(DatePicker datePickerView, TimePicker timePickerView, int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minute);
    }

    public DateTimePickerDialog(Context context, OnDateTimeSetListener callBack, Date date, boolean is24HourView) {
        super(context);

        mDateTimeCallBack = callBack;

        final GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);

        mInitialYear = cal.get(Calendar.YEAR);
        mInitialMonth = cal.get(Calendar.MONTH);
        mInitialDay = cal.get(Calendar.DAY_OF_MONTH);
        mInitialHour = cal.get(Calendar.HOUR_OF_DAY);
        mInitialMinute = cal.get(Calendar.MINUTE);

        mTitleDateFormat = java.text.DateFormat.getDateTimeInstance(java.text.DateFormat.MEDIUM, java.text.DateFormat.SHORT);

        mCalendar = Calendar.getInstance();
        updateTitle(mInitialYear, mInitialMonth, mInitialDay, mInitialHour, mInitialMinute);

        setButton(DialogInterface.BUTTON_POSITIVE, context.getString(android.R.string.ok), this);
        setButton(DialogInterface.BUTTON_NEGATIVE, context.getString(android.R.string.cancel), (OnClickListener) null);

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.date_time_picker, null);
        setView(view);

        mDatePicker = (DatePicker) view.findViewById(R.id.date_picker);
        mDatePicker.init(mInitialYear, mInitialMonth, mInitialDay, this);

        mTimePicker = (TimePicker) view.findViewById(R.id.time_picker);
        mTimePicker.setIs24HourView(is24HourView);
        mTimePicker.setCurrentHour(mInitialHour);
        mTimePicker.setCurrentMinute(mInitialMinute);
        mTimePicker.setOnTimeChangedListener(this);
    }

    public void onClick(DialogInterface dialog, int which) {
        if (mDateTimeCallBack != null) {
            mDatePicker.clearFocus();
            mDateTimeCallBack.onDateTimeSet(
                    mDatePicker,
                    mTimePicker,
                    mDatePicker.getYear(),
                    mDatePicker.getMonth(),
                    mDatePicker.getDayOfMonth(),
                    mTimePicker.getCurrentHour(),
                    mTimePicker.getCurrentMinute());
        }
    }

    private void updateTitle(int year, int month, int day, int hourOfDay, int minute) {
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, day);
        mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        mCalendar.set(Calendar.MINUTE, minute);

        setTitle(mTitleDateFormat.format(mCalendar.getTime()));
    }

    @Override
    public Bundle onSaveInstanceState() {
        final Bundle state = super.onSaveInstanceState();
        state.putInt(YEAR, mDatePicker.getYear());
        state.putInt(MONTH, mDatePicker.getMonth());
        state.putInt(DAY, mDatePicker.getDayOfMonth());
        state.putInt(HOUR_OF_DAY, mTimePicker.getCurrentHour());
        state.putInt(MINUTE, mTimePicker.getCurrentMinute());
        return state;
    }

    @Override
    public void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final int year = savedInstanceState.getInt(YEAR);
        final int month = savedInstanceState.getInt(MONTH);
        final int day = savedInstanceState.getInt(DAY);
        final int hourOfDay = savedInstanceState.getInt(HOUR_OF_DAY);
        final int minute = savedInstanceState.getInt(MINUTE);
        mDatePicker.init(year, month, day, this);
        mTimePicker.setCurrentHour(hourOfDay);
        mTimePicker.setCurrentMinute(minute);
        updateTitle(year, month, day, hourOfDay, minute);

    }

    @Override
    public void onDateChanged(DatePicker view, int year, int month, int day) {
        mInitialYear = year;
        mInitialMonth = month;
        mInitialDay = day;
        updateTitle(year, month, day, mInitialHour, mInitialMinute);
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        mInitialHour = hourOfDay;
        mInitialMinute = minute;
        updateTitle(mInitialYear, mInitialMonth, mInitialDay, hourOfDay, minute);
    }
}
