package com.example.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity {

    private long backBtnTime = 0;
    private TextView textView;

    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView1);
        calendarView = findViewById(R.id.simpleCalendarView);

        //날짜 클릭시 값 넘겨주는 메쏘드
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() { //선택된 것의 날짜를 알려주는 메쏘드
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "/" + (month + 1) + "/" + dayOfMonth;
                Log.d(TAG, "onSelectedDauChange : mm/dd/yyyy : " + date);

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });


//        MultiTransformation<Bitmap> multi = new MultiTransformation<>(new BlurTransformation(25), new GrayscaleTransformation());
//        Glide.with(holder.itemView.getContext()).load(uri).apply(RequestOptions.bitmapTransform(multi)).into(holder.imageView);
//                GradientDrawable gradientDrawable = (GradientDrawable) GroupMessageActivity.this.getDrawable(R.drawable.radius);
//                holder.imageView.setBackground(gradientDrawable);
//                holder.imageView.setClipToOutline(true);
//        holder.imageView.post(new Runnable() {
//            @Override
//            public void run() {
//                holder.progressbar.setVisibility(View.VISIBLE);
//                holder.progressbar.getIndeterminateDrawable().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.MULTIPLY);
//            }.
//        });
//        textView.setOnClickListener(v -> {
//            startActivity(new Intent(getApplicationContext(), RecycleImageActivity.class));
//        });
    }


    // 두번 눌러서 종료하기
    @Override
    public void onBackPressed() {
        //첫번째 눌렀을 때 막고

        //두번째 눌렀을 때 종료
        long curTime = System.currentTimeMillis();
        long gapTime = curTime - backBtnTime;

        if (0 <= gapTime && 2000 >= gapTime) {
            super.onBackPressed();
        } else {
            backBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }
}