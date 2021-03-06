package com.example.poornima.globetrot2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Info extends BaseActivity {
    private CardView cardView;
    static boolean active = false;
    private ProgressDialog progressDialog;
    private View percentRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_info, frameLayout);
        mDrawerList.setItemChecked(new String(inList).indexOf('a'), true);
        setTitle(getTitle());

        percentRelativeLayout = findViewById(R.id.percentRelativeLayout_info);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Checking Your Status Please Wait");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        /*recyclerView = (RecyclerView) findViewById(R.id.recyclerView_home_screen);
        LayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new GridAdaptar(list);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new HomeScreenRecyclerViewItemClickListener(HomeScreen.this, new HomeScreenRecyclerViewItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (position == 0) {
                            Intent intent = new Intent(HomeScreen.this, Info.class);
                            startActivity(intent);
                        } else if (position == 1) {
                            Intent intent = new Intent(HomeScreen.this, Natcon.class);
                            startActivity(intent);
                        } else if (position == 2) {
                            Intent intent = new Intent(HomeScreen.this, Schedules.class);
                            startActivity(intent);
                        } else if (position == 3) {
                            progressDialog.show();
                            ConnectivityManager cm = (ConnectivityManager) HomeScreen.this.getSystemService(Context.CONNECTIVITY_SERVICE);
                            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                            if (activeNetwork != null) {
                                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {

                                        if (dataSnapshot.child("natconregistered").getValue().toString().equals("no")) {
                                            progressDialog.dismiss();
                                            startActivity(new Intent(HomeScreen.this, NatconRegister.class));
                                            finish();
                                        } else if (dataSnapshot.child("natconregistered").getValue().toString().equals("denied")) {
                                            progressDialog.dismiss();
                                            Snackbar snackbar = Snackbar.make(percentRelativeLayout, "YOUR NATCON REGISTRATION DETAILS ARE INCORRECT.PLEASE RE-REGISTER", Snackbar.LENGTH_INDEFINITE);

                                            snackbar.setAction("OK", new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    startActivity(new Intent(HomeScreen.this, NatconRegister.class));
                                                }
                                            });
                                            snackbar.setActionTextColor(getResources().getColor(R.color.snackbarActionColor));
                                            snackbar.show();
                                        } else if (dataSnapshot.child("natconregistered").getValue().toString().equals("approved")) {
                                            if (dataSnapshot.child("paymentstatus").getValue().toString().equals("pending")) {
                                                progressDialog.dismiss();
                                                startActivity(new Intent(HomeScreen.this, PaymentGateway.class));
                                            } else if (dataSnapshot.child("paymentstatus").getValue().toString().equals("approved")) {
                                                progressDialog.dismiss();
                                                startActivity(new Intent(HomeScreen.this, HomeScreen.class));
                                            }
                                            else {
                                                Toast.makeText(HomeScreen.this, "YOUR NATCON REGISTRATION HAS BEEN APPROVED", Toast.LENGTH_SHORT).show();
                                            }
                                        } else if (dataSnapshot.child("natconregistered").getValue().toString().equals("pending")) {
                                            progressDialog.dismiss();
                                            Toast.makeText(HomeScreen.this, "NATCON REGISTRATION APPROVAL PENDING", Toast.LENGTH_SHORT).show();
                                        }

                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }
                                });
                            } else {
                                Toast.makeText(HomeScreen.this, "PLEASE CONNECT TO INTERNET AND TRY AGAIN.", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        } else if (position == 4) {
                            Intent intent = new Intent(HomeScreen.this, VenueAndTravel.class);
                            startActivity(intent);
                        } else if (position == 5) {
                            Intent intent = new Intent(HomeScreen.this, Transport.class);
                            startActivity(intent);
                        } else if (position == 6) {
                            Intent intent = new Intent(HomeScreen.this, Networking.class);
                            startActivity(intent);
                        } else if (position == 7) {
                            Intent intent = new Intent(HomeScreen.this, Sponsers.class);
                            startActivity(intent);
                        } else if (position == 8) {
                            Intent intent = new Intent(HomeScreen.this, Contactus.class);
                            startActivity(intent);
                        }

                    }
                })
        );
*/
    }


    @Override
    public void onStart() {
        super.onStart();
        mDrawerList.setItemChecked(new String(inList).indexOf('a'), true);
        active = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        active = false;
    }


    public void InfoPostOffice(View view) {
        Intent intent = new Intent(Info.this, InfoPostOffice.class);
        startActivity(intent);
    }
    public void InfoPolice(View view) {
        Intent intent = new Intent(Info.this, InfoPolice.class);
        startActivity(intent);
    }
    public void InfoFireStation(View view) {
        Intent intent = new Intent(Info.this, InfoFireStation.class);
        startActivity(intent);
    }
    public void InfoEmbssy(View view) {
        Intent intent = new Intent(Info.this, InfoEmbssy.class);
        startActivity(intent);
    }
    public void InfoCabServices(View view) {
        Intent intent = new Intent(Info.this, InfoCabServices.class);
        startActivity(intent);
    }
    public void InfoHospital(View view) {
        Intent intent = new Intent(Info.this, InfoHospital.class);
        startActivity(intent);
    }



}
