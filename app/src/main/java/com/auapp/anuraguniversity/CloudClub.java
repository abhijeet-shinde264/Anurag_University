package com.auapp.anuraguniversity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CloudClub extends AppCompatActivity {

    ViewGroup v1;
    TextView t1,t2,t3,t4;
    Button b1,b2,b3;
    ImageView i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_club);
        v1 = findViewById(R.id.lin_layout_cloud);
        t1 = findViewById(R.id.cc_team_text);
        t2 = findViewById(R.id.cc_event_1_text);
        t3 = findViewById(R.id.cc_event_2_text);
        t4 = findViewById(R.id.cc_achi_text);
        b1 = findViewById(R.id.cc_team);
        b2 = findViewById(R.id.cc_event);
        b3 = findViewById(R.id.cc_achi);
        i1 = findViewById(R.id.cc_event_1);
        i2 = findViewById(R.id.cc_event_2);
        b1.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(v1);
                }
                visible = !visible;
                t1.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(v1);
                }
                visible = !visible;
                i1.setVisibility(visible ? View.VISIBLE : View.GONE);
                t2.setVisibility(visible ? View.VISIBLE : View.GONE);
                i2.setVisibility(visible ? View.VISIBLE : View.GONE);
                t3.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(v1);
                }
                visible = !visible;
                t4.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Cloud Club");
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