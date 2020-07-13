package com.auapp.anuraguniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Android_details_student extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7;
    ImageView i1;
    Button report,delete,edate;
    String s1,s2,s3,s4,s5,s6,s7,s8,att,feed,newlink,s9,postkey;
    Spanned text,text1;
    //Events events;
    DatabaseReference reference,ref1;
    FirebaseAuth mauth;
    String currentuserid;
    String email1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_details_student);
        t1 = findViewById(R.id.eretriname);
        t2 = findViewById(R.id.redate);
        t3 = findViewById(R.id.retyesr);
        t4 = findViewById(R.id.retclub);
        t5 = findViewById(R.id.retinfo);
        t6 = findViewById(R.id.retlink1);
        t7 = findViewById(R.id.retlink2);
        i1 = findViewById(R.id.imageret);
        report = findViewById(R.id.report);
        delete = findViewById(R.id.delete);
        edate = findViewById(R.id.editdate);
        mauth = FirebaseAuth.getInstance();
        currentuserid = mauth.getCurrentUser().getUid();
        FirebaseUser user=mauth.getCurrentUser();
        email1=user.getEmail();
//        FirebaseUser user = mauth.getCurrentUser();
//        email1 = user.getEmail();
        final String mail1=mauth.getCurrentUser().getEmail();
        final String email1="abhijeetshinde1999@gmail.com";
        final Calendar myCalendar = Calendar.getInstance();
        if (mail1.equals(email1)){
            delete.setVisibility(View.VISIBLE);
        }
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Android_details_student.this, "Working", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeletePost();
            }
        });
        //events = new Events();
        postkey = getIntent().getStringExtra("key");
        reference = FirebaseDatabase.getInstance().getReference().child("Events").child(postkey);
        ref1 = FirebaseDatabase.getInstance().getReference().child("Information");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    s1 = snapshot.child("eventname").getValue().toString();
                    s2 = snapshot.child("data").getValue().toString();
                    s3 = snapshot.child("tstudent").getValue().toString();
                    s4 = snapshot.child("name").getValue().toString();
                    s5 = snapshot.child("profil").getValue().toString();
                    s6 = snapshot.child("link").getValue().toString();
                    s7 = snapshot.child("olink").getValue().toString();
                    s8 = snapshot.child("img").getValue().toString();
                    t1.setText(s1);
                    t2.setText(s2);
                    t3.setText(s3);
                    t4.setText(s4);
                    t5.setText(s5);
                    //t6.setText(s6);
                    //t7.setText(s7);
                    text = Html.fromHtml("<a href="+s6+">Registeration Link</a>");
                    t6.setMovementMethod(LinkMovementMethod.getInstance());
                    t6.setText(text);
                    Picasso.get()
                            .load(s8)
                            .fit()
                            .centerCrop()
                            .into(i1);
                    if (s7.isEmpty()){
                        t7.setText("No link");
                    }else{
                        //t7.setText(s7);
                        text1 = Html.fromHtml("<a href="+s6+">Optional Link</a>");
                        t7.setMovementMethod(LinkMovementMethod.getInstance());
                        t7.setText(text1);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void DeletePost() {
        reference.removeValue();
        SendToMainActivity();
        Toast.makeText(this, "Post has been deleted....", Toast.LENGTH_SHORT).show();
    }
    private void SendToMainActivity() {
        Intent i1 = new Intent(Android_details_student.this,EventRetrival.class);
        i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i1);
    }
}