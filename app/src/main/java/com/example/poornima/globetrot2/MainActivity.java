package com.example.poornima.globetrot2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void test(View view){
        Intent intent= new Intent(MainActivity.this,LoginAcitvity.class);
        startActivity(intent);
    }


}
