package com.example.myquranapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ByParah2 extends AppCompatActivity {

    ArrayList<Names> namesList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_parah2);

        DataObject dataObject = new DataObject();
        for (int i = 0; i < dataObject.englishParahName.length; i++) {
            Names temp = new Names();
            temp.eng = dataObject.englishParahName[i];
            temp.urdu = dataObject.ParahName[i];
            namesList.add(temp);
        }

        recyclerView = findViewById(R.id.parahRecyclerView);

        //LinearLayoutManager GridLayoutManager
        //layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager = new LinearLayoutManager(ByParah2.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(namesList);
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

        Intent oldIntent = getIntent();
        String viewType = oldIntent.getStringExtra("viewType");

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(ByParah2.this, Translation.class);
                        intent.putExtra("Index", position);
                        intent.putExtra("Type", "Parah");
                        intent.putExtra("viewType", viewType);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Intent intent = new Intent(ByParah2.this, Translation.class);
                        intent.putExtra("Index", position);
                        intent.putExtra("Type", "Parah");
                        intent.putExtra("viewType", viewType);
                        startActivity(intent);
                    }
                })
        );
    }
}