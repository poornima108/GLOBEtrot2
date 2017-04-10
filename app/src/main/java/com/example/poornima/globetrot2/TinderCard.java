package com.example.poornima.globetrot2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hp on 07-04-2017.
 */


    @Layout(R.layout.tinder_card_view)
    public class TinderCard {

        @View(R.id.profileImageView)
        private ImageView profileImageView;

        @View(R.id.nameAgeTxt)
        private TextView nameAgeTxt;

        @View(R.id.locationNameTxt)
        private TextView locationNameTxt;

        private Data mData;
        private Context mContext;
        private SwipePlaceHolderView mSwipeView;

        public TinderCard(Context context, Data data, SwipePlaceHolderView swipeView) {
            mContext = context;
            mData = data;
            mSwipeView = swipeView;
        }

        @Resolve
        private void onResolved(){
            String url = getUrl(mData.getPhotoList());
            FetchUrl3 fetchUrl3=new FetchUrl3();

            fetchUrl3.execute(url);
            nameAgeTxt.setText(mData.getNameList() + ", " + mData.getRatingList());
            locationNameTxt.setText("Helllllllooo");
            profileImageView.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    Intent intent = new Intent(mContext, CardOpen.class);
                    intent.putExtra("Rating",mData.getRatingList());
                    intent.putExtra("Name", mData.getNameList());
                    intent.putExtra("Photo", mData.getPhotoList());
                    mContext.startActivity(intent);
                }
            });
        }

        @SwipeOut
        private void onSwipedOut(){
            Log.d("EVENT", "onSwipedOut");
            //mSwipeView.addView(this);
        }

        @SwipeCancelState
        private void onSwipeCancelState(){
            Log.d("EVENT", "onSwipeCancelState");
        }

    @SwipeIn
    private void onSwipeIn() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://globetrot-1e21d.firebaseio.com/fav/" + FirebaseAuth.getInstance().getCurrentUser().getUid());
        String x = mData.getNameList();
        databaseReference.child(x).child("name").setValue(x);
        databaseReference.child(x).child("rating").setValue(mData.getRatingList().toString());
        databaseReference.child(x).child("photo").setValue(mData.getPhotoList());
        // sharedPreferences.edit().putString("TCRating",mData.getRatingList().toString()).apply();
        //sharedPreferences.edit().putString("TCPhoto",mData.getPhotoList()).apply();

        Log.d("EVENT", "onSwipedIn");
    }

        @SwipeInState
        private void onSwipeInState(){
            //Toast.makeText(mContext, "Swiped In!!", Toast.LENGTH_SHORT).show();
            Log.d("EVENT", "onSwipeInState");
        }

        @SwipeOutState
        private void onSwipeOutState(){
            Log.d("EVENT", "onSwipeOutState");
        }


    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            Log.d("downloadUrl", data.toString());
            br.close();

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    private String getUrl(String imageRef) {

        String url = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=300&maxheight=300&photoreference=" + imageRef + "&key=AIzaSyDiVcwvbnTMkElMLZojlbtc8wrOItvpioY";

        return url;
    }

    private class FetchUrl3 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = url[0];
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Glide.with(mContext).load(result).into(profileImageView);
        }




    }
    }

