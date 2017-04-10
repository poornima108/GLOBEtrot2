package com.example.poornima.globetrot2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InfoFireStation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_fire_station);

        String type="fire_station";
        Intent i= new Intent(this, MapsActivity.class);
        i.putExtra("type",type);
        startActivity(i);
        finish();
    }
}
