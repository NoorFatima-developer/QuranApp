package com.example.myquranapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AyahView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayah_view);

        ListView listview = findViewById(R.id.listAyah);

        Intent intent = getIntent();
        int index = intent.getIntExtra("Index", 0);
        String type = intent.getStringExtra("Type");
        String translation = intent.getStringExtra("Translation");

        DBHelper dbHelper = new DBHelper(AyahView.this);
        ArrayList<Names> myList = dbHelper.getAyahAndTranslation(index, type, translation);

//        ArrayList<String> verses = dbHelper.populateAyah(type, index);
//        ArrayList<String> Translated = dbHelper.translation(type, translation, index);

//        CustomBaseAdapter cba = new CustomBaseAdapter(getApplicationContext(), verses, Translated);
//        listview.setAdapter(cba);

        AyahAdapter arrayAdapter = new AyahAdapter(AyahView.this, android.R.layout.simple_list_item_1, myList);
        listview.setAdapter(arrayAdapter);
    }
}