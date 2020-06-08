package com.auapp.anuraguniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupPage extends AppCompatActivity {
    RelativeLayout rellay1;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
        }
    };
    EditText name,suemail,supass,sucpass;
    Button signup;
    ProgressDialog PD;
    FirebaseAuth firebaseAuth;
    String s1,s2,s3;
    DatabaseReference databaseReference;
    SignupPage1 signupPage1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        name = findViewById(R.id.suname);
        suemail = findViewById(R.id.suemail);
        supass = findViewById(R.id.supass);
        sucpass = findViewById(R.id.sucpass);
        firebaseAuth = FirebaseAuth.getInstance();
        signupPage1 = new SignupPage1();
        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = supass.getText().toString().trim();
                s2 = sucpass.getText().toString().trim();
                s3 = suemail.getText().toString().trim();
                if((name.getText().toString().isEmpty()) || (suemail.getText().toString().isEmpty()) ||
                        (supass.getText().toString().isEmpty()) || (sucpass.getText().toString().isEmpty())){
                    Toast.makeText(SignupPage.this, "Please fill the details", Toast.LENGTH_SHORT).show();
                }else if ((s1.length()<6)){
                    supass.setError("Password must be of 6 character length.");
                }else if ((!s1.equals(s2))){
                    Toast.makeText(SignupPage.this, "Please check the password.", Toast.LENGTH_SHORT).show();
                }
                else if((s1).equals(s2)){
                    firebaseAuth.createUserWithEmailAndPassword(s3,s1)
                            .addOnCompleteListener(SignupPage.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(SignupPage.this.getApplicationContext(),
                                                "SignUp unsuccessful: " + task.getException().getMessage(),
                                                Toast.LENGTH_SHORT).show();
                                    }else{
                                        signupPage1.setName(name.getText().toString().trim());
                                        signupPage1.setEmail(suemail.getText().toString().trim());
                                        databaseReference.push().setValue(signupPage1);
                                        Intent i1 = new Intent(SignupPage.this,MainActivity.class);
                                        startActivity(i1);
                                        finish();
                                    }
                                }
                            });
                }
            }
        });
    }
}