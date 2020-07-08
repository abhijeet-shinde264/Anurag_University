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

public class UnderGrad extends AppCompatActivity implements ClickListener{
    RecyclerView rv;
    UGAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_grad);
        rv = findViewById(R.id.rvug);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UGAdapter(this,getPlayers());
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Under Graduate (UG)");
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
        p.setText("Chemical Engineering");
        p.setImg(R.drawable.chem_ug);
        models.add(p);
        p = new RecycleModel();
        p.setText("Computer Science and Engineering");
        p.setImg(R.drawable.cse_ug);
        models.add(p);
        p = new RecycleModel();
        p.setText("Civil Engineering");
        p.setImg(R.drawable.cv_ug);
        models.add(p);
        p = new RecycleModel();
        p.setText("Electrical and Electronics Engineering");
        p.setImg(R.drawable.eee_ug);
        models.add(p);
        p = new RecycleModel();
        p.setText("Electronics and Communication Engineering");
        p.setImg(R.drawable.ece_ug);
        models.add(p);
        p = new RecycleModel();
        p.setText("Information Technology");
        p.setImg(R.drawable.it_ug);
        models.add(p);
        p = new RecycleModel();
        p.setText("Construction Technology and Management");
        p.setImg(R.drawable.ctm_ug);
        models.add(p);
        p = new RecycleModel();
        p.setText("Mechanical Engineering");
        p.setImg(R.drawable.me_ug);
        models.add(p);
        p = new RecycleModel();
        p.setText("Artificial Intelligence");
        p.setImg(R.drawable.ai_ug);
        models.add(p);
        p = new RecycleModel();
        p.setText("Computer Science and Systems Engineering");
        p.setImg(R.drawable.csse_ug);
        models.add(p);
        p = new RecycleModel();
        p.setText("Artificial Intelligence and Machine Learning");
        p.setImg(R.drawable.aiml_ug);
        models.add(p);
        return models;
    }

    @Override
    public void itemClicked(View view, int position) {
        if (position == 0){
            Intent i1 = new Intent(UnderGrad.this,ChemUg.class);
            startActivity(i1);
//            Toast.makeText(this, "Under Work", Toast.LENGTH_SHORT).show();
        }else if (position == 1){
            startActivity(new Intent(UnderGrad.this,CseUg.class));
//            Toast.makeText(this, "Under Work", Toast.LENGTH_SHORT).show();
        }else if (position == 2){
            Intent i1 = new Intent(UnderGrad.this,CivilUG.class);
            startActivity(i1);
//            Toast.makeText(this, "Under Work", Toast.LENGTH_SHORT).show();
        }else if (position == 3){
            startActivity(new Intent(getApplicationContext(),EeeUg.class));
//            Toast.makeText(this, "Under Work", Toast.LENGTH_SHORT).show();
        }else if (position == 4){
            startActivity(new Intent(getApplicationContext(),EceUg.class));
//            Toast.makeText(this, "Under Work", Toast.LENGTH_SHORT).show();
        }else if (position == 5){
            startActivity(new Intent(getApplicationContext(),ItUg.class));
//            Toast.makeText(this, "Under Work", Toast.LENGTH_SHORT).show();
        }else if (position == 6){
            startActivity(new Intent(getApplicationContext(),CtmUg.class));
//            Toast.makeText(this, "Under Work", Toast.LENGTH_SHORT).show();
        }else if (position == 7){
            startActivity(new Intent(getApplicationContext(),MeUg.class));
//            Toast.makeText(this, "Under Work", Toast.LENGTH_SHORT).show();
        }else if (position == 8){
            startActivity(new Intent(getApplicationContext(),AiUg.class));
//            Toast.makeText(this, "Under Work", Toast.LENGTH_SHORT).show();
        }else if (position == 9){
            startActivity(new Intent(getApplicationContext(),CsseUg.class));
//            Toast.makeText(this, "Under Work", Toast.LENGTH_SHORT).show();
        }else if (position == 10){
            startActivity(new Intent(getApplicationContext(),AimlUg.class));
//            Toast.makeText(this, "Under Work", Toast.LENGTH_SHORT).show();
        }
    }
}