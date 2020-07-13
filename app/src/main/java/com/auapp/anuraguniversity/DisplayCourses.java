package com.auapp.anuraguniversity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayCourses extends AppCompatActivity implements ClickListener{
    RecyclerView rv;
    DisplayCourseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_courses);
        rv = findViewById(R.id.rv1);
        //rv.setLayoutManager(new GridLayoutManager(this,2));
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DisplayCourseAdapter(this,getPlayers());
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Courses");
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
        p.setText("UNDER GRADUATE (UG)");
        p.setImg(R.drawable.ug);
        models.add(p);
        p = new RecycleModel();
        p.setText("POST GRADUATE (PG)");
        p.setImg(R.drawable.pg);
        models.add(p);
        p = new RecycleModel();
        p.setText("DOCTORATE PROGRAMS (PH.D)");
        p.setImg(R.drawable.phd);
        models.add(p);
        return models;
    }
    @Override
    public void itemClicked(View view, int position) {
        if (position == 0){
            Intent i1 = new Intent(DisplayCourses.this,UnderGrad.class);
            startActivity(i1);
            //Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
        }else if (position == 1){
            startActivity(new Intent(DisplayCourses.this,PostGrad.class));
            //Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
        }else if (position == 2){
            startActivity(new Intent(DisplayCourses.this,DrctPhd.class));
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
        }
    }
}