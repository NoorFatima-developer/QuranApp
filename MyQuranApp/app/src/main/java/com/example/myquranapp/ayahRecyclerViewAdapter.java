package com.example.myquranapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ayahRecyclerViewAdapter extends RecyclerView.Adapter<ayahRecyclerViewAdapter.MyNewVH> {

    ArrayList<Names> namesList;
    public ayahRecyclerViewAdapter(ArrayList<Names> namesList) {
        this.namesList = namesList;
    }

    @NonNull
    @Override
    public ayahRecyclerViewAdapter.MyNewVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ayah_layout, parent, false);
        return new MyNewVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ayahRecyclerViewAdapter.MyNewVH holder, int position) {
        holder.data = namesList.get(position);
        holder.urduSurah.setText(holder.data.getUrdu());
        holder.engSurah.setText(holder.data.getEng());
    }

    @Override
    public int getItemCount() {
        return namesList.size();
    }

    public static class MyNewVH extends RecyclerView.ViewHolder {
        TextView urduSurah;
        TextView engSurah;
        Names data;
        public MyNewVH(@NonNull View itemView) {
            super(itemView);
            urduSurah = itemView.findViewById(R.id.ayahArabicTextView);
            engSurah = itemView.findViewById(R.id.ayahTranslatedView);
        }
    }
}
