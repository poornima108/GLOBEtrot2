package com.example.poornima.globetrot2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InfoPostOffice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_post_office);
        String type="post_office";
        Intent i= new Intent(this, MapsActivity.class);
        i.putExtra("type",type);
        startActivity(i);
        finish();
    }
}
