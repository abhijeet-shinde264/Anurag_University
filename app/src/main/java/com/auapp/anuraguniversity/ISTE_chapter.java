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

public class ISTE_chapter extends AppCompatActivity {
    Button iste_1,iste_2,iste_3,iste_4;
    LinearLayout iste_l;
    TextView iste_tv1,iste_tv2,iste_tv3,iste_tv4,iste_tv5,iste_tv6;
    ImageView iste_img1,iste_img2,iste_img3,iste_img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_s_t_e_chapter);
        iste_l = findViewById(R.id.lin_layout_iste);
        iste_tv1 = findViewById(R.id.iste_about_text);
        iste_tv2 = findViewById(R.id.iste_eve_1_txt);
        iste_tv3 = findViewById(R.id.iste_eve_2_txt);
        iste_tv4 = findViewById(R.id.iste_achieve_1_txt);
        iste_tv5 = findViewById(R.id.iste_achieve_2_txt);
        iste_tv6 = findViewById(R.id.iste_team_txt);

        iste_1 = findViewById(R.id.iste_about);
        iste_2 = findViewById(R.id.iste_eve_btn);
        iste_3 =findViewById(R.id.iste_achieve_btn);
        iste_4 = findViewById(R.id.iste_team_btn);

        iste_img1 = findViewById(R.id.iste_eve_1);
        iste_img2 = findViewById(R.id.iste_eve_2);
        iste_img3 = findViewById(R.id.iste_achieve_1);
        iste_img4 = findViewById(R.id.iste_achieve_2);

        iste_1.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(iste_l);
                }
                visible = !visible;
                iste_tv1.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        iste_2.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(iste_l);
                }
                visible = !visible;
                iste_img1.setVisibility(visible ? View.VISIBLE : View.GONE);
                iste_img2.setVisibility(visible ? View.VISIBLE : View.GONE);
                iste_tv2.setVisibility(visible ? View.VISIBLE : View.GONE);
                iste_tv3.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        iste_3.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(iste_l);
                }
                visible = !visible;
                iste_img4.setVisibility(visible ? View.VISIBLE : View.GONE);
                iste_img3.setVisibility(visible ? View.VISIBLE : View.GONE);
                iste_tv4.setVisibility(visible ? View.VISIBLE : View.GONE);
                iste_tv5.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        iste_4.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(iste_l);
                }
                visible = !visible;
                iste_tv6.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("ISTE Chapters");
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