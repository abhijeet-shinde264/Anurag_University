package com.auapp.anuraguniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    private Button btnSignup,btfp;
    EditText email,pass;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };
    private FirebaseAuth firebaseAuth;
    //FirebaseUser user;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        firebaseAuth = FirebaseAuth.getInstance();
//        lg = findViewById(R.id.btnLogin);
        btnSignup=(Button)findViewById(R.id.btnSignup);
        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);
        email = findViewById(R.id.lgemail);
        pass = findViewById(R.id.lgpass);
        btfp = findViewById(R.id.forgotpass);
        btfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(LoginPage.this,ForgotPassword.class);
                startActivity(i1);
            }
        });
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(LoginPage.this, "Welcome Back ", Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(LoginPage.this, MainActivity.class);
                    startActivity(I);
                    finish();
                } else {
                    Toast.makeText(LoginPage.this, "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
                    Toast.makeText(LoginPage.this,"Pl enter the details",Toast.LENGTH_LONG).show();
                }
                else if (!(email.getText().toString().isEmpty() && pass.getText().toString().isEmpty())){

//                    PD.show();
                    firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                            .addOnCompleteListener(LoginPage.this, new OnCompleteListener() {
                                @Override
                                public void onComplete(@NonNull Task task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(LoginPage.this, "Not sucessfull", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Intent i1 = new Intent(LoginPage.this, MainActivity.class);
                                        startActivity(i1);
                                        finish();
                                    }
                                }
                            });
                    //PD.dismiss();
                }
                else {
                    Toast.makeText(LoginPage.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setTitle("Login Page");
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
    }
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }
}