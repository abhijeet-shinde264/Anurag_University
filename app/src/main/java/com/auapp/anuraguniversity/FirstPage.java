package com.auapp.anuraguniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirstPage extends AppCompatActivity {

    Button bsign,blogin;
    private FirebaseAuth firebaseAuth;
    //FirebaseUser user;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        bsign = findViewById(R.id.signup);
        blogin = findViewById(R.id.login);
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(FirstPage.this, "Welcome Back ", Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(FirstPage.this, MainActivity.class);
                    startActivity(I);
                    finish();
                } else {
                    Toast.makeText(FirstPage.this, "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };
        bsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(FirstPage.this,SignupPage.class);
                startActivity(i1);
            }
        });
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(FirstPage.this,LoginPage.class);
                startActivity(i2);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Home Page");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}