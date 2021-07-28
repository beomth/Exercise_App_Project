package com.example.calendar;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.CustomViewHolder> {


    Context context;

    private ArrayList<ImageData> arrayList;

    public RecycleAdapter(ArrayList<ImageData> arrayList) {
        this.arrayList = arrayList;
    }


    @Override
    public RecycleAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    //실제 추가될 때 새염ㅇ주기
    @Override
    public void onBindViewHolder(RecycleAdapter.CustomViewHolder holder, int position) {
        holder.image1.setImageResource((arrayList.get(position).getImage1()));
        holder.image2.setImageResource((arrayList.get(position).getImage2()));
        holder.image3.setImageResource((arrayList.get(position).getImage3()));
        holder.image4.setImageResource((arrayList.get(position).getImage4()));
        holder.image5.setImageResource((arrayList.get(position).getImage5()));
        holder.image6.setImageResource((arrayList.get(position).getImage6()));

        holder.itemView.setTag(position);


    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView image1;
        protected ImageView image2;
        protected ImageView image3;
        protected ImageView image4;
        protected ImageView image5;
        protected ImageView image6;


        public CustomViewHolder(View itemView) {
            super(itemView);
            this.image1 = (ImageView) itemView.findViewById(R.id.image1);
            this.image2 = (ImageView) itemView.findViewById(R.id.image2);
            this.image3 = (ImageView) itemView.findViewById(R.id.image3);
            this.image4 = (ImageView) itemView.findViewById(R.id.image4);
            this.image5 = (ImageView) itemView.findViewById(R.id.image5);
            this.image6 = (ImageView) itemView.findViewById(R.id.image6);


        }
    }




}
