package com.auapp.anuraguniversity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class DrctPhd extends AppCompatActivity implements ClickListener{
    RecyclerView rv;
    UGAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drct_phd);
        rv = findViewById(R.id.phd);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UGAdapter(this,getPlayers());
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Doctorate Programs (PH.D)");
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

    private ArrayList<RecycleModel> getPlayers() {
        ArrayList<RecycleModel> models = new ArrayList<>();
        RecycleModel p = new RecycleModel();
        p.setText("Pharmacy");
        p.setImg(R.drawable.pharphd);
        models.add(p);
        p = new RecycleModel();
        p.setText("Management");
        p.setImg(R.drawable.manphd);
        models.add(p);
        return models;
    }

    @Override
    public void itemClicked(View view, int position) {
        if (position == 0){
            startActivity(new Intent(getApplicationContext(),PharPhd.class));
        }else if (position == 1){
            startActivity(new Intent(getApplicationContext(),MangPhd.class));
        }
    }
}