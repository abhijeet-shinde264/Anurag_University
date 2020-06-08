package com.auapp.anuraguniversity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AndroidClub extends AppCompatActivity {
    ViewGroup v1;
    Button b1,b2,b3,b4;
    TextView tv1;
    ImageView eve1,eve2,eve3,achieve1,achieve2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_club);
        v1 = findViewById(R.id.lin_layout_1);
        b1 = findViewById(R.id.andy_about);
        b2 = findViewById(R.id.andy_eve_btn);
        b3 = findViewById(R.id.andy_achieve_btn);
        b4 = findViewById(R.id.andy_team_btn);
        tv1 = findViewById(R.id.andy_about_text);
        eve1 =findViewById(R.id.andy_eve_1);
        eve2 = findViewById(R.id.andy_eve_2);
        eve3 = findViewById(R.id.andy_eve_3);
        achieve1 = findViewById(R.id.andy_achieve_1);
        achieve2 = findViewById(R.id.andy_achieve_2);

        b1.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(v1);
                }
                visible = !visible;
                tv1.setVisibility(visible ? View.VISIBLE : View.GONE);
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
                eve1.setVisibility(visible ? View.VISIBLE : View.GONE);
                eve2.setVisibility(visible ? View.VISIBLE : View.GONE);
                eve3.setVisibility(visible ? View.VISIBLE : View.GONE);

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
                achieve1.setVisibility(visible ? View.VISIBLE : View.GONE);
                achieve2.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

//        b4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i1 = new Intent(AndroidClub.this, IoT_club_info.class);
//                startActivity(i1);
//            }
//        });

        ActionBar actionBar = getSupportActionBar();
       if (actionBar != null) {
           actionBar.setTitle("Android Club");
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