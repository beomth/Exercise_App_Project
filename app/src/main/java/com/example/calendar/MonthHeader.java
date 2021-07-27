package com.example.calendar;

import android.view.View;
import android.widget.TextView;

import com.kizitonwose.calendarview.ui.ViewContainer;

public class MonthHeader extends ViewContainer {

    public final TextView textView;

    public MonthHeader(View view) {
        super(view);
        textView = view.findViewById(R.id.calendarMonthText);
    }
}
