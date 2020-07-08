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

public class IEEE_chapter extends AppCompatActivity {
    Button ieee_1,ieee_2,ieee_3,ieee_4;
    LinearLayout ieee_l;
    TextView ieee_tv1,ieee_tv2,ieee_tv3,ieee_tv4,ieee_tv5;
    ImageView ieee_img1,ieee_img2,ieee_img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_e_e_e_chapter);
        ieee_l = findViewById(R.id.lin_layout_ieee);

        ieee_1 = findViewById(R.id.ieee_about);
        ieee_2 = findViewById(R.id.ieee_eve_btn);
        ieee_3 = findViewById(R.id.ieee_achieve_btn);
        ieee_4 = findViewById(R.id.ieee_team_btn);

        ieee_tv1 = findViewById(R.id.ieee_about_text);
        ieee_tv2 = findViewById(R.id.ieee_eve_1_txt);
        ieee_tv3 = findViewById(R.id.ieee_eve_2_txt);
        ieee_tv4 = findViewById(R.id.ieee_achieve_1_txt);
        ieee_tv5 = findViewById(R.id.ieee_team_txt);

        ieee_img1 = findViewById(R.id.ieee_eve_1);
        ieee_img2 = findViewById(R.id.ieee_eve_2);
        ieee_img3 = findViewById(R.id.ieee_achieve_1);

        ieee_1.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(ieee_l);
                }
                visible = !visible;
                ieee_tv1.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        ieee_2.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(ieee_l);
                }
                visible = !visible;
                ieee_tv2.setVisibility(visible ? View.VISIBLE : View.GONE);
                ieee_tv3.setVisibility(visible ? View.VISIBLE : View.GONE);
                ieee_img1.setVisibility(visible ? View.VISIBLE : View.GONE);
                ieee_img2.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        ieee_3.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(ieee_l);
                }
                visible = !visible;
                ieee_tv4.setVisibility(visible ? View.VISIBLE : View.GONE);
                ieee_img3.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        ieee_4.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(ieee_l);
                }
                visible = !visible;
                ieee_tv5.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("IEEE Chapters");
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