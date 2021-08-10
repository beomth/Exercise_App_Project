package com.example.calendar;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImgRecyclerAdapter imgRecyclerAdapter;
    List<String> imgList;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);

        imgList = new ArrayList<>();
        imgList.add("rony");
        imgList.add("what_color");
        imgList.add("foot_color");
        imgList.add("leg_raise_color");
        imgList.add("push_up_color");



        imgRecyclerAdapter = new ImgRecyclerAdapter();
        recyclerView = findViewById(R.id.img_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(imgRecyclerAdapter);

        textView = findViewById(R.id.textView_recycle);

        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        textView.setText(date);
    }




    class ImgRecyclerAdapter extends RecyclerView.Adapter<ImgRecyclerAdapter.CustomViewHolder> {

        private ImgRecyclerAdapter() {
        }

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img, parent, false);
            return new CustomViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
            Log.d("포지션", position+"");
            String imgName = imgList.get(position);
            Context context = holder.itemView.getContext();
            int imageResource = context.getResources().getIdentifier(imgName, "drawable", context.getPackageName());
            Glide.with(context).load(imageResource).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return imgList.size();
        }


        private class CustomViewHolder extends RecyclerView.ViewHolder {
           private ImageView imageView;

            private CustomViewHolder(View view) {
                super(view);
                imageView = view.findViewById(R.id.image1);
            }
        }
    }
}
