package com.example.poornima.globetrot2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Restaurant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        String type="restaurant";
        Intent i= new Intent(this, MapsActivity.class);
        i.putExtra("type",type);
        startActivity(i);
        finish();
    }
}
