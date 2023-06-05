package com.example.myquranapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ByParah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_parah);

        DataObject dataObject = new DataObject();
        List<Names> array = new ArrayList<>();
        for (int i = 0; i < dataObject.englishParahName.length; i++) {

            Names temp = new Names();
            temp.eng = dataObject.englishParahName[i];
            temp.urdu = dataObject.ParahName[i];
            array.add(temp);
        }

        MainAdapter arrayAdapter = new MainAdapter(ByParah.this, android.R.layout.simple_list_item_1, array);
        ListView listView = findViewById(R.id.listParah);
        listView.setAdapter(arrayAdapter);

        Intent oldIntent = getIntent();
        String viewType = oldIntent.getStringExtra("viewType");

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(ByParah.this, Translation.class);
            intent.putExtra("Index", i);
            intent.putExtra("Type", "Parah");
            intent.putExtra("viewType", viewType);
            startActivity(intent);

//                int start = dataObject.getParahStart(i);
//                int end;
//                try{
//                    end = dataObject.getParahStart(i+1);
//                }catch (Exception e){
//                    end = DataObject.QuranArabicText.length+1;
//                }
//                Intent intent = new Intent(ByParah.this, Translation.class);
//                intent.putExtra("Start", start);
//                intent.putExtra("End",end);
//                startActivity(intent);
        });
    }
}