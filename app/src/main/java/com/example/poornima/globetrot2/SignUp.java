package com.example.poornima.globetrot2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {
    private Button register;
    private DatabaseReference mdatabase;

    private EditText mfname;
    private EditText mpass;
    private EditText mconfpass;
    private EditText mlname;
    private EditText mdob;
    private EditText memail;
    private EditText mphone_no;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        register = (Button) findViewById(R.id.register);
        mdatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://globetrot-1e21d.firebaseio.com/users");

        mfname = (EditText) findViewById(R.id.fname);
        mlname = (EditText) findViewById(R.id.lname);
        mpass = (EditText) findViewById(R.id.pass);
        mconfpass = (EditText) findViewById(R.id.confpass);
        mdob = (EditText) findViewById(R.id.dob);
        memail = (EditText) findViewById(R.id.email);
        mphone_no = (EditText) findViewById(R.id.phone_no);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String fname = mfname.getText().toString().trim();
                final String lname = mlname.getText().toString().trim();
                final String pass = mpass.getText().toString().trim();
                final String confpass = mconfpass.getText().toString().trim();
                final String dob = mdob.getText().toString().trim();
                final String phone_no = mphone_no.getText().toString().trim();
                final String email = memail.getText().toString().trim();


                if (!pass.equals(confpass)) {
                    Toast.makeText(SignUp.this, "Enter Same Password Again", Toast.LENGTH_LONG).show();
                } else {

                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUp.this, R.string.auth_failed,
                                        Toast.LENGTH_SHORT).show();
                                Log.e("sdfsdfsdfsdfsd", "onComplete: "+task.toString() );
                            } else {

                                String userid= FirebaseAuth.getInstance().getCurrentUser().getUid();


                                Log.e("DATABASE", "onComplete: " + userid);
                                mdatabase.child(userid).child("firstname").setValue(fname);
                                mdatabase.child(userid).child("lastname").setValue(lname);
                                mdatabase.child(userid).child("dob").setValue(dob);
                                mdatabase.child(userid).child("mobile").setValue(phone_no);
                                mdatabase.child(userid).child("email").setValue(email);
                                mdatabase.child(userid).child("password").setValue(pass);


                                Toast.makeText(SignUp.this, "Registered..", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, HomeScreen.class));
                                finish();

                            }
                        }
                    });


                }
            }
        });
    }

}
