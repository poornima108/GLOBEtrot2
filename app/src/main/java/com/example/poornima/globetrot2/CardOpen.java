package com.example.poornima.globetrot2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CardOpen extends AppCompatActivity {

    public Double rating;
    ImageView imageView;

    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_open);

        Intent intent = getIntent();
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
       // imageView = (ImageView) findViewById(R.id.imageView);
        tv1.setText(intent.getStringExtra("Name"));
        rating = intent.getDoubleExtra("Rating", 0);
        tv2.setText(rating.toString());
       // Glide.with(getApplicationContext()).load(intent.getStringExtra("Photo")).into(imageView);
    }
}
