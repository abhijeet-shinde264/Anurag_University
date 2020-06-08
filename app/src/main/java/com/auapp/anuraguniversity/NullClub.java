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

public class NullClub extends AppCompatActivity {
    Button nb1,nb2,nb3;
    TextView ntv1;
    ImageView ni1,ni2,ni3,ni4,ni5;
    LinearLayout nl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_null_club);
        nl = findViewById(R.id.lin_layout_null);

        nb1 = findViewById(R.id.null_about);
        nb2 = findViewById(R.id.null_eve_btn);
        nb3 =  findViewById(R.id.null_achieve_btn);

        ntv1 = findViewById(R.id.null_about_text);

        ni1 = findViewById(R.id.null_eve_1);
        ni2 = findViewById(R.id.null_eve_2);
        ni3 = findViewById(R.id.null_eve_3);
        ni4 = findViewById(R.id.null_achieve_1);
        ni5 = findViewById(R.id.null_achieve_2);

        nb1.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(nl);
                }
                visible = !visible;
                ntv1.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        nb2.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(nl);
                }
                visible = !visible;
                ni1.setVisibility(visible ? View.VISIBLE : View.GONE);
                ni2.setVisibility(visible ? View.VISIBLE : View.GONE);
                ni3.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });

        nb3.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(nl);
                }
                visible = !visible;
                ni4.setVisibility(visible ? View.VISIBLE : View.GONE);
                ni5.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Null Club");
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