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

public class Clubs extends AppCompatActivity implements ClickListener{
    RecyclerView rv;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);
        rv = findViewById(R.id.recycleview);
        //rv.setLayoutManager(new GridLayoutManager(this,2));
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this,getPlayers());
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Clubs");
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
        p.setText("Android Club");
        p.setImg(R.drawable.and_2);
        models.add(p);
        p = new RecycleModel();
        p.setText("IoT Club");
        p.setImg(R.drawable.iot);
        models.add(p);
        p = new RecycleModel();
        p.setText("Malai Club");
        p.setImg(R.drawable.malai_logo);
        models.add(p);
        p = new RecycleModel();
        p.setText("DSC Club");
        p.setImg(R.drawable.dsc);
        models.add(p);
        p = new RecycleModel();
        p.setText("Cloud Club");
        p.setImg(R.drawable.cloudclub);
        models.add(p);
        p = new RecycleModel();
        p.setText("Null Club");
        p.setImg(R.drawable.nullclubb);
        models.add(p);
        p = new RecycleModel();
        p.setText("Web Club");
        p.setImg(R.drawable.web_2);
        models.add(p);
        p = new RecycleModel();
        p.setText("Data Analytics Club");
        p.setImg(R.drawable.daa);
        models.add(p);
        return models;
    }

    @Override
    public void itemClicked(View view, int position) {
        if (position == 0){
//            Intent i1 = new Intent(HomeActivity.this,JobseekerPosts.class);
//            startActivity(i1);
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getApplicationContext(),AndroidClub.class);
            startActivity(i1);
        }else if (position == 1){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getApplicationContext(),IOTClub.class);
            startActivity(i1);
        }else if (position == 2){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getApplicationContext(),MalaiClub.class);
            startActivity(i1);
        }else if (position == 3){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getApplicationContext(),DscClub.class);
            startActivity(i1);
        }else if (position == 4){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getApplicationContext(),CloudClub.class);
            startActivity(i1);
        }else if (position == 5){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getApplicationContext(),NullClub.class);
            startActivity(i1);
        }else if (position == 6){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getApplicationContext(),WebClub.class);
            startActivity(i1);
        }
        else if (position == 7){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(getApplicationContext(),DataAnaliticsClub.class);
            startActivity(i1);
        }
    }
}