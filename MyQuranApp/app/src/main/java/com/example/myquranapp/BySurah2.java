package com.example.myquranapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BySurah2 extends AppCompatActivity {

    ArrayList<Names> namesList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_surah2);

        dbHelper = new DBHelper(BySurah2.this);
        namesList = dbHelper.populateSurah();

        recyclerView = findViewById(R.id.surahRecyclerView);

        Intent oldIntent = getIntent();
        String viewType = oldIntent.getStringExtra("viewType");

        //LinearLayoutManager GridLayoutManager
        //layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager = new LinearLayoutManager(BySurah2.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(namesList);
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(BySurah2.this, Translation.class);
                        intent.putExtra("Index", position);
                        intent.putExtra("Type", "Surah");
                        intent.putExtra("viewType", viewType);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Intent intent = new Intent(BySurah2.this, Translation.class);
                        intent.putExtra("Index", position);
                        intent.putExtra("Type", "Surah");
                        intent.putExtra("viewType", viewType);
                        startActivity(intent);
                    }
                })
        );
    }
}

