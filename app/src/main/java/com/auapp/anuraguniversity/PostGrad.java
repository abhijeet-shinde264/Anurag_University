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

public class PostGrad extends AppCompatActivity implements ClickListener{
    RecyclerView rv;
    UGAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_grad);
        rv = findViewById(R.id.rvpg);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UGAdapter(this,getPlayers());
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Post Graduate(PG)");
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
        p.setText("VILS System Design");
        p.setImg(R.drawable.vlsisdpg);
        models.add(p);
        p = new RecycleModel();
        p.setText("Computer Science and Engineering");
        p.setImg(R.drawable.csepg);
        models.add(p);
        p = new RecycleModel();
        p.setText("Structural Engineering");
        p.setImg(R.drawable.sepg);
        models.add(p);
        p = new RecycleModel();
        p.setText("Power Electronics and Electrical Drives");
        p.setImg(R.drawable.peedpg);
        models.add(p);
        p = new RecycleModel();
        p.setText("Electrical Power Systems");
        p.setImg(R.drawable.epspg);
        models.add(p);
        p = new RecycleModel();
        p.setText("Machine Design");
        p.setImg(R.drawable.mdpg);
        models.add(p);
        return models;
    }

    @Override
    public void itemClicked(View view, int position) {
        if (position == 0){
            startActivity(new Intent(getApplicationContext(),VsdPg.class));
        }else if (position == 1){
            startActivity(new Intent(getApplicationContext(),CsePg.class));
        }else if (position == 2){
            startActivity(new Intent(getApplicationContext(),SePg.class));
        }else if (position == 3){
            startActivity(new Intent(getApplicationContext(),PeedPg.class));
        }else if (position == 4){
            startActivity(new Intent(getApplicationContext(),EpsPg.class));
        }else if (position == 5){
            startActivity(new Intent(getApplicationContext(),MdPg.class));
        }
    }
}