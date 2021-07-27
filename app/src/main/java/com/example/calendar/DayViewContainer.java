package com.example.calendar;

import android.view.View;
import android.widget.TextView;

import com.kizitonwose.calendarview.model.CalendarDay;
import com.kizitonwose.calendarview.ui.ViewContainer;

import java.util.Calendar;

public class DayViewContainer extends ViewContainer {

    public final TextView textView;


    public DayViewContainer(View view) {
        super(view);

        textView = view.findViewById(R.id.calendarDayText);



    }
}
