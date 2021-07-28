package com.example.calendar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

    private long BackBtnTime = 0;
    public static final int REQUEST_CODE = 777;
    CalendarView calendarView;

    //onCreate
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

        //달력 뷰를 보여주고, 클릭했을 때 인텐트 값을 넘겨줌
        calendarView.setDayBinder(new DayBinder<DayViewContainer>() {
            @Override
            public DayViewContainer create(View view) {
                return new DayViewContainer(view);
            }

            @Override
            public void bind(DayViewContainer viewContainer, CalendarDay calendarDay) {
                String dayOfMonth = calendarDay.getDate().getDayOfMonth() + "";
                viewContainer.textView.setText(dayOfMonth);
                viewContainer.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Sub.class);
                        startActivityForResult(intent, REQUEST_CODE);
                    }
                });

            }
        });
        //뷰 보여줌
        YearMonth currentMonth = YearMonth.now();
        YearMonth firstMonth = currentMonth.minusMonths(12);
        YearMonth lastMonth = currentMonth.plusMonths(12);
        DayOfWeek firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();
        calendarView.setup(firstMonth, lastMonth, firstDayOfWeek);
        calendarView.scrollToMonth(currentMonth);
    }


    //인텐트 값을 받음
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Toast.makeText(getApplicationContext(), "예아", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "으아", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        long curTime = System.currentTimeMillis();
        long gapTime = curTime - BackBtnTime;

        if(0 <= gapTime && 2000 >= gapTime){
            super.onBackPressed();
        }
        else{
            BackBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show();
        }

    }
}