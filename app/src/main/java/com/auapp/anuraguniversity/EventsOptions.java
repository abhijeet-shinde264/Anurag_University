package com.auapp.anuraguniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class EventsOptions extends AppCompatActivity {
    LinearLayout cd1,cd2;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_options);
        cd1=findViewById(R.id.cd_ieee);
        cd2=findViewById(R.id.cd2_ieee);
        //toolbar = (Toolbar) findViewById(R.id.toolbar_ieee);
        //   setSupportActionBar(toolbar);
        auth=FirebaseAuth.getInstance();
        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventsOptions.this,AddEvent.class);
                startActivity(intent);
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventsOptions.this,EventRetrival.class);
                startActivity(intent);
            }
        });
    }
}