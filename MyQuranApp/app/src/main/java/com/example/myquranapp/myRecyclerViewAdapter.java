package com.example.myquranapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyVH> {

    ArrayList<Names> namesList;
    public myRecyclerViewAdapter(ArrayList<Names> namesList) {
        this.namesList = namesList;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.surah_layout, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyVH holder, int position) {
        holder.data = namesList.get(position);
        holder.urduSurah.setText(holder.data.getUrdu());
        holder.engSurah.setText(holder.data.getEng());
        holder.number.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return namesList.size();
    }

    public static class MyVH extends RecyclerView.ViewHolder {
        TextView urduSurah;
        TextView engSurah;
        TextView number;
        Names data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            urduSurah = itemView.findViewById(R.id.textView2);
            engSurah = itemView.findViewById(R.id.textView);
            number = itemView.findViewById(R.id.rowNo);
        }
    }
}