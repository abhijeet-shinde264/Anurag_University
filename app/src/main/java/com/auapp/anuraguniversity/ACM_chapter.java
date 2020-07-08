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

public class ACM_chapter extends AppCompatActivity {
    Button acm_1,acm_2,acm_3,acm_4;
    LinearLayout acm_l;
    TextView acm_tv1,acm_tv2,acm_tv3,acm_tv4,acm_tv5;
    ImageView acm_img1,acm_img2,acm_img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_c_m_chapter);
        acm_l = findViewById(R.id.lin_layout_acm);

        acm_1 = findViewById(R.id.acm_about);
        acm_2 = findViewById(R.id.acm_eve_btn);
        acm_3 = findViewById(R.id.acm_achieve_btn);
        acm_4 = findViewById(R.id.acm_team_btn);

        acm_tv1 = findViewById(R.id.acm_about_text);
        acm_tv2 = findViewById(R.id.acm_eve_1_txt);
        acm_tv3 = findViewById(R.id.acm_eve_2_txt);
        acm_tv4 = findViewById(R.id.acm_achieve_1_txt);
        acm_tv5 = findViewById(R.id.acm_team_txt);

        acm_img1 = findViewById(R.id.acm_eve_1);
        acm_img2 = findViewById(R.id.acm_eve_2);
        acm_img3 = findViewById(R.id.acm_achieve_1);

        acm_1.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(acm_l);
                }
                visible = !visible;
                acm_tv1.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        acm_2.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(acm_l);
                }
                visible = !visible;
                acm_tv2.setVisibility(visible ? View.VISIBLE : View.GONE);
                acm_tv3.setVisibility(visible ? View.VISIBLE : View.GONE);
                acm_img1.setVisibility(visible ? View.VISIBLE : View.GONE);
                acm_img2.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        acm_3.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(acm_l);
                }
                visible = !visible;
                acm_tv4.setVisibility(visible ? View.VISIBLE : View.GONE);
                acm_img3.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        acm_4.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(acm_l);
                }
                visible = !visible;
                acm_tv5.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("ACM Chapters");
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