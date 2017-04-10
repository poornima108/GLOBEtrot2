package com.example.poornima.globetrot2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.poornima.globetrot2.HomeScreen;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginAcitvity extends AppCompatActivity {

    ImageButton imageButton;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText memail,mpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitvity);

        memail = (EditText) findViewById(R.id.editText3);
        mpass = (EditText) findViewById(R.id.editText2);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    startActivity(new Intent(LoginAcitvity.this,HomeScreen.class));
                    finish();
                } else {
                    Toast.makeText(LoginAcitvity.this, "Please Log In", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
    public void onButtonClick(View v)
    {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
    public void onSignInClick(View v) {
        String email = memail.getText().toString();
        String pass = mpass.getText().toString();
        if (!email.isEmpty() && !pass.isEmpty()) {
            mAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(LoginAcitvity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                                Log.e("FSDSDSDSDSSSS", "onComplete: " + task.toString());
                                Toast.makeText(LoginAcitvity.this, "Invalid email or password..", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
        }
        else {
            Toast.makeText(this, "ENTER EMAIL AND PASSWORD", Toast.LENGTH_SHORT).show();
        }
    }
}
