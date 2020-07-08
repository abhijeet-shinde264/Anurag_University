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

public class Chapters extends AppCompatActivity implements ClickListener{
    RecyclerView rv;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);
        rv = findViewById(R.id.recycleviewchapters);
        //rv.setLayoutManager(new GridLayoutManager(this,2));
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this,getPlayers());
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Chapters");
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
    private ArrayList<RecycleModel> getPlayers(){
        ArrayList<RecycleModel> models = new ArrayList<>();
        RecycleModel p = new RecycleModel();
        p.setText("ACM Chapter");
        p.setImg(R.drawable.acm_logo);
        models.add(p);
        p = new RecycleModel();
        p.setText("CSI Chapter");
        p.setImg(R.drawable.csi_logo);
        models.add(p);
        p = new RecycleModel();
        p.setText("IEEE Chapter");
        p.setImg(R.drawable.ieee_logo);
        models.add(p);
        p = new RecycleModel();
        p.setText("ISTE Chapter");
        p.setImg(R.drawable.iste_logo);
        models.add(p);
        return models;
    }
    @Override
    public void itemClicked(View view, int position) {
        if (position == 0){
            Intent i1 = new Intent(Chapters.this,ACM_chapter.class);
            startActivity(i1);
        }else if (position == 1){
            Intent i1 = new Intent(Chapters.this,CSI_chapter.class);
            startActivity(i1);
        }else if (position == 2){
            Intent i1 = new Intent(Chapters.this,IEEE_chapter.class);
            startActivity(i1);
        }else if (position == 3){
            Intent i1 = new Intent(Chapters.this,ISTE_chapter.class);
            startActivity(i1);
        }
    }
}