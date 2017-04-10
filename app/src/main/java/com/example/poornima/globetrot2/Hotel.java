package com.example.poornima.globetrot2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Hotel extends AppCompatActivity {
public String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        type="lodging";
        Intent intent = new Intent(this, MapsHotelActivity.class);
        startActivity(intent);
        finish();
    }
}
