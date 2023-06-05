package com.example.myquranapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Translation extends AppCompatActivity {

    Button b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        b1 = findViewById(R.id.fateh_urdu);
        b2 = findViewById(R.id.mehmood_urdu);
        b3 = findViewById(R.id.dr_english);
        b4 = findViewById(R.id.mufti_english);

        Intent intent = getIntent();
        int index = intent.getIntExtra("Index", 0);
        String type = intent.getStringExtra("Type");
        String viewType = intent.getStringExtra("viewType");
//        int start = intent.getIntExtra("Start",-1);
//        int end = intent.getIntExtra("End",-1);

        Intent newIntent = null;
        if(viewType.equals("list")){
            newIntent = new Intent(Translation.this, AyahView.class);
        }
        else if(viewType.equals("recycler")){
            newIntent = new Intent(Translation.this, AyahView2.class);
        }

        newIntent.putExtra("Index", index);
        newIntent.putExtra("Type", type);

        Intent finalNewIntent = newIntent;
        b1.setOnClickListener(view -> {
            finalNewIntent.putExtra("Translation", "urdu1");
            startActivity(finalNewIntent);
        });

        Intent finalNewIntent1 = newIntent;
        b2.setOnClickListener(view -> {
            finalNewIntent1.putExtra("Translation", "urdu2");
            startActivity(finalNewIntent1);
        });

        Intent finalNewIntent2 = newIntent;
        b3.setOnClickListener(view -> {
            finalNewIntent2.putExtra("Translation", "eng1");
            startActivity(finalNewIntent2);
        });

        Intent finalNewIntent3 = newIntent;
        b4.setOnClickListener(view -> {
            finalNewIntent3.putExtra("Translation", "eng2");
            startActivity(finalNewIntent3);
        });
    }
}