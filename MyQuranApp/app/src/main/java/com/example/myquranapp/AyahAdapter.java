package com.example.myquranapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AyahAdapter extends ArrayAdapter {
    public AyahAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Names chapter = (Names) getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_ayah,null,true);

        TextView arabicTV = convertView.findViewById(R.id.arabicTextView);
        arabicTV.setText(chapter.getUrdu());
        TextView translateTV = convertView.findViewById(R.id.translationTextView);
        translateTV.setText(chapter.getEng());

        return convertView;
    }
}