package com.example.rahul.materialdesign;

/**
 * Created by Rahul on 6/21/2017.
 */

import android.content.Context;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context mContext;
    private List<Desing> desingList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);

            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.back);
        }
    }


    public Adapter(Context mContext, List<Desing> albumList) {
        this.mContext = mContext;
        this.desingList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Desing desing = desingList.get(position);
        holder.overflow.setBackgroundColor(Color.parseColor(desing.getColor()));
        Glide.with(mContext).load(desing.getCover()).override(150,150).into(holder.thumbnail);

    }


    @Override
    public int getItemCount() {
        return desingList.size();
    }
}