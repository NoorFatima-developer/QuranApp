package com.example.myquranapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> verses;
    ArrayList<String> translated;
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, ArrayList<String> verses, ArrayList<String> translated){
        this.context = ctx;
        this.verses = verses;
        this.translated = translated;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return verses.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.custom_ayah,null, true);
        TextView arabic = view.findViewById(R.id.arabicTextView);
        TextView translation = view.findViewById(R.id.translationTextView);

        arabic.setText(verses.get(i));
        translation.setText(translated.get(i));

        return view;
    }
}
