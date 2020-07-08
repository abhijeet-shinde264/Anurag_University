package com.auapp.anuraguniversity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WebClub extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;
    LinearLayout l1;
    TextView t1,t2,t3,t4,t5,t6,t7;
    ImageView i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_club);
        b1 = findViewById(R.id.web_about);
        b2 = findViewById(R.id.web_event);
        b3 = findViewById(R.id.web_project);
        b4 = findViewById(R.id.web_achivement);
        b5 = findViewById(R.id.web_team_btn);
        l1 = findViewById(R.id.lin_layout_web);

        t1 = findViewById(R.id.web_about_text);
        t2 = findViewById(R.id.project1);
        t3 = findViewById(R.id.project2);
        t4 = findViewById(R.id.project3);
        t5 = findViewById(R.id.project4);
        t6 = findViewById(R.id.project5);
        t7 = findViewById(R.id.web_team_txt);

        i1 = findViewById(R.id.webevents1);
        i2 = findViewById(R.id.webachivement1);

        b1.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(l1);
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
                    TransitionManager.beginDelayedTransition(l1);
                }
                visible = !visible;
                i1.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(l1);
                }
                visible = !visible;
                t2.setVisibility(visible ? View.VISIBLE : View.GONE);
                t3.setVisibility(visible ? View.VISIBLE : View.GONE);
                t4.setVisibility(visible ? View.VISIBLE : View.GONE);
                t5.setVisibility(visible ? View.VISIBLE : View.GONE);
                t6.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(l1);
                }
                visible = !visible;
                i2.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(l1);
                }
                visible = !visible;
                t7.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Web Club");
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