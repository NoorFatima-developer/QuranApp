package com.example.myquranapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AyahView2 extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    ArrayList<Names> myList;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayah_view2);

        recyclerView = findViewById(R.id.recyclerAyah);

        Intent intent = getIntent();
        int index = intent.getIntExtra("Index", 0);
        String type = intent.getStringExtra("Type");
        String translation = intent.getStringExtra("Translation");

        dbHelper = new DBHelper(AyahView2.this);
        myList = dbHelper.getAyahAndTranslation(index, type, translation);

        layoutManager = new LinearLayoutManager(AyahView2.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ayahRecyclerViewAdapter(myList);
        recyclerView.setAdapter(adapter);
    }
}