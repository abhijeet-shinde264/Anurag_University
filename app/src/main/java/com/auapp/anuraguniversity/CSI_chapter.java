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

public class CSI_chapter extends AppCompatActivity {
    Button csi_1,csi_2,csi_3,csi_4;
    LinearLayout csi_l;
    TextView csi_tv1,csi_tv2,csi_tv3,csi_tv4,csi_tv5;
    ImageView csi_img1,csi_img2,csi_img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_s_i_chapter);
        csi_l = findViewById(R.id.lin_layout_csi);

        csi_1 = findViewById(R.id.csi_about);
        csi_2 = findViewById(R.id.csi_eve_btn);
        csi_3 = findViewById(R.id.csi_achieve_btn);
        csi_4 = findViewById(R.id.csi_team_btn);

        csi_tv1 = findViewById(R.id.csi_about_text);
        csi_tv2 = findViewById(R.id.csi_eve_1_txt);
        csi_tv3 = findViewById(R.id.csi_achieve_1_txt);
        csi_tv4 = findViewById(R.id.csi_achieve_2_txt);
        csi_tv5 = findViewById(R.id.csi_team_txt);

        csi_img1 = findViewById(R.id.csi_eve_1);
        csi_img3 = findViewById(R.id.csi_achieve_2);
        csi_img2 = findViewById(R.id.csi_achieve_1);

        csi_1.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(csi_l);
                }
                visible = !visible;
                csi_tv1.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        csi_2.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(csi_l);
                }
                visible = !visible;
                csi_tv2.setVisibility(visible ? View.VISIBLE : View.GONE);
                csi_img1.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        csi_3.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(csi_l);
                }
                visible = !visible;
                csi_tv3.setVisibility(visible ? View.VISIBLE : View.GONE);
                csi_tv4.setVisibility(visible ? View.VISIBLE : View.GONE);
                csi_img3.setVisibility(visible ? View.VISIBLE : View.GONE);
                csi_img2.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        csi_4.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(csi_l);
                }
                visible = !visible;
                csi_tv5.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("CSI Chapters");
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