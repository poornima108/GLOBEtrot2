package com.example.poornima.globetrot2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Place extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        String type="synagogue";
        Intent i= new Intent(this, MapsActivity.class);
        i.putExtra("type",type);
        startActivity(i);
        finish();
    }
}
