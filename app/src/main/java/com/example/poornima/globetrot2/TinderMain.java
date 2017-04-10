package com.example.poornima.globetrot2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mindorks.placeholderview.*;

public class TinderMain extends AppCompatActivity {

    public static SwipePlaceHolderView mSwipeView;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinder_main);

        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        MapsHotelActivity mapsHotelActivity= new MapsHotelActivity();


        if(mapsHotelActivity.flag==true)
        {
        for(final Data data : MapsHotelActivity.dataGetter(this.getApplicationContext())){
            mSwipeView.addView(new TinderCard(mContext,data, mSwipeView));

        }}
        else{
            for(final Data data : MapsHotelActivity.dataGetter(this.getApplicationContext())){
                mSwipeView.addView(new TinderCard(mContext,data, mSwipeView));
              //  Toast.makeText(mapsHotelActivity, "amma C", Toast.LENGTH_SHORT).show();

            }
        }

//        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mSwipeView.doSwipe(false);
//                TinderCard t= new TinderCard();
//                t.onSw
//            }
//        });
//
//        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mSwipeView.doSwipe(true);
//            }
//        });
    }
}