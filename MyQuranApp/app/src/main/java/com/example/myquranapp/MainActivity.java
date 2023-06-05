package com.example.myquranapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    //Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            //Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();
        }
        else {
            drawerLayout.closeDrawer(GravityCompat.START);
            //Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        navigationView=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId())
            {
                case R.id.nav_home :
                    //Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    //drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_BySurah:
                    //Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                    Intent intent2 = new Intent(MainActivity.this, BySurah.class);
                    intent2.putExtra("viewType", "list");
                    startActivity(intent2);
                    //drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_ByParah:
                    Intent intent3 = new Intent(MainActivity.this, ByParah.class);
                    intent3.putExtra("viewType", "list");
                    startActivity(intent3);
                    break;

                case R.id.nav_BySurah2:
                    //Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                    Intent intent5 = new Intent(MainActivity.this, BySurah2.class);
                    intent5.putExtra("viewType", "recycler");
                    startActivity(intent5);
                    //drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_ByParah2:
                    //Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                    Intent intent6 = new Intent(MainActivity.this, ByParah2.class);
                    intent6.putExtra("viewType", "recycler");
                    startActivity(intent6);
                    //drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_ByAyah:
//                    Intent intent4 = new Intent(MainActivity.this, MainActivity.class);
//                    startActivity(intent4);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
            }
            return true;
        });
    }
}