package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kizitonwose.calendarview.CalendarView;
import com.kizitonwose.calendarview.model.CalendarDay;
import com.kizitonwose.calendarview.model.CalendarMonth;
import com.kizitonwose.calendarview.ui.DayBinder;
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder;
import com.kizitonwose.calendarview.ui.ViewContainer;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView);

        calendarView.setMonthHeaderBinder(new MonthHeaderFooterBinder<MonthHeader>() {
            @Override
            public MonthHeader create(View view) {
                return new MonthHeader(view);
            }

            @Override
            public void bind(MonthHeader viewContainer, CalendarMonth calendarMonth) {
                String year = calendarMonth.getYear() + "년";
                String month = calendarMonth.getMonth() + "월";
                viewContainer.textView.setText(year + " " + month);

            }
        });


        calendarView.setDayBinder(new DayBinder<DayViewContainer>() {
            @Override
            public DayViewContainer create(View view) {
                return new DayViewContainer(view);
            }

            @Override
            public void bind(DayViewContainer viewContainer, CalendarDay calendarDay) {
                String dayOfMonth = calendarDay.getDate().getDayOfMonth()+ "";
                viewContainer.textView.setText(dayOfMonth);

                viewContainer.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(this, RecycleAdapter.class);
                        intent.putExtra("day", dayOfMonth);
                        startActivityForResult(this, RecycleAdapter);
                    }
                });

            }
        });



        YearMonth currentMonth = YearMonth.now();
        YearMonth firstMonth = currentMonth.minusMonths(12);
        YearMonth lastMonth = currentMonth.plusMonths(12);
        DayOfWeek firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();
        calendarView.setup(firstMonth, lastMonth, firstDayOfWeek);
        calendarView.scrollToMonth(currentMonth);

    }
}