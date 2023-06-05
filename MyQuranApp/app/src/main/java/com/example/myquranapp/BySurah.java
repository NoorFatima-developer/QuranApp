package com.example.myquranapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BySurah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_surah);

        DBHelper dbHelper = new DBHelper(BySurah.this);
        ArrayList<Names> myList = dbHelper.populateSurah();

        MainAdapter arrayAdapter = new MainAdapter(BySurah.this, android.R.layout.simple_list_item_1, myList);
        ListView listView = findViewById(R.id.listSurah);
        listView.setAdapter(arrayAdapter);

        Intent oldIntent = getIntent();
        String viewType = oldIntent.getStringExtra("viewType");

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(BySurah.this, Translation.class);
            intent.putExtra("Index", i);
            intent.putExtra("Type", "Surah");
            intent.putExtra("viewType", viewType);
            startActivity(intent);

//                DataObject dataObject = new DataObject();
//                int start = dataObject.getSurahStart(i);
//                int end;
//                try{
//                    end = dataObject.getSurahStart(i+1);
//                }
//                catch (Exception e){
//                    end = DataObject.QuranArabicText.length+1;
//                }
//                Intent intent = new Intent(BySurah.this, Translation.class);
//                intent.putExtra("Index", i);
//                intent.putExtra("Start", start);
//                intent.putExtra("End",end);
//                startActivity(intent);
        });
    }
}