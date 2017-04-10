package com.example.poornima.globetrot2;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Favourites extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);


        final LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);


        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://globetrot-1e21d.firebaseio.com/fav/" + FirebaseAuth.getInstance().getCurrentUser().getUid());
        // textView = (TextView) findViewById(R.id.textView3);
        String name[];
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                linearLayout.removeAllViews();
                for (final DataSnapshot ds : dataSnapshot.getChildren()) {

                    TextView textView = new TextView(Favourites.this);
                    textView.setText(ds.child("name").getValue().toString()+" ,"+ds.child("rating").getValue().toString());

                    TextView textView1 = new TextView(Favourites.this);
                    textView1.setText("---------------");

                    Button button =new Button(Favourites.this);
                    button.setText("UN FAV");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(Favourites.this, "UN FAVOURITED "+ds.child("name").getValue().toString(), Toast.LENGTH_SHORT).show();
                            databaseReference.child(ds.child("name").getValue().toString()).removeValue();
                        }
                    });


                    linearLayout.addView(textView);
                    linearLayout.addView(button);
                    linearLayout.addView(textView1);


                   /* TextView textView1 = new TextView(Favourites.this);
                    textView.setText(ds.child("rating").getValue().toString());
                    linearLayout.addView(textView1);*/

                    /*TextView textView2 = new TextView(Favourites.this);
                    textView.setText("----------------------------------");
                    linearLayout.addView(textView2);*/
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //  String rating = sharedPreferences.getString("TCRating",null);
        // String phot = sharedPreferences.getString("TCPhoto",null);


    }
}
