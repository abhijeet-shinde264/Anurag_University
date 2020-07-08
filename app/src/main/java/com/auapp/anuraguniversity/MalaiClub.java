package com.auapp.anuraguniversity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MalaiClub extends AppCompatActivity {
    Button mlb1,mlb2;
    LinearLayout ml1;
    TextView mlt1,mlt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malai_club);
        ml1 = findViewById(R.id.lin_layout_ml_ai);
        mlb1 = findViewById(R.id.malai_team_btn);
        mlb2 = findViewById(R.id.ml_ai_about);
        mlt1 = findViewById(R.id.malai_team_txt);
        mlt2 = findViewById(R.id.ml_ai_about_text);

        mlb1.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(ml1);
                }
                visible = !visible;
                mlt1.setVisibility(visible ? View.VISIBLE : View.GONE);

            }
        });

        mlb2.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(ml1);
                }
                visible = !visible;
                mlt2.setVisibility(visible ? View.VISIBLE : View.GONE);

            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Malai Club");
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