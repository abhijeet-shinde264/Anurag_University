package com.auapp.anuraguniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,ClickListener{
    DrawerLayout dLayout;
    ActionBarDrawerToggle mToggle;
    RecyclerView rv;
    MyAdapter adapter;
    private FirebaseAuth mAuth;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
//        email=mAuth.getCurrentUser().getEmail();
        email=mAuth.getCurrentUser().getEmail();
        rv = findViewById(R.id.recycleview);
        //rv.setLayoutManager(new GridLayoutManager(this,2));
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this,getPlayers());
        rv.setAdapter(adapter);
        adapter.setClickListener(this);
        dLayout = findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(MainActivity.this,dLayout,R.string.open,R.string.close);
        dLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nview);
        navigationView.setNavigationItemSelectedListener(this);
//        String mail = "17h61a0561@cvsr.ac.in";
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id =menuItem.getItemId();
//        String mail = "17h61a0561@cvsr.ac.in";
        mAuth = FirebaseAuth.getInstance();
        switch (id){
            case R.id.clubs:
//                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                Intent i4 = new Intent(MainActivity.this,MainActivity.class);
                startActivity(i4);
                break;
            case R.id.chapters:
                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                break;
            case R.id.event:
//                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                String mail="abhijeetshinde1999@gmail.com";
                //String email;
//                FirebaseUser user=mAuth.getCurrentUser();
//                email=user.getEmail();
//                if(email.equals(mail)){
////                    Intent i2 = new Intent(MainActivity.this,EventtPost.class);
////                    startActivity(i2);
//                }else {
//                    Intent i3 = new Intent(MainActivity.this,ShowEvents.class);
//                    startActivity(i3);
//                }
                break;
            case R.id.placment:
                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                break;

            case R.id.inteship:
                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                break;
            case R.id.map:
                //Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(MainActivity.this,MapActivity.class);
                startActivity(i1);
                break;
            case R.id.achivements:
//                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                String mail1="abhijeetshinde1999@gmail.com";
                //String email;
                FirebaseUser user1=mAuth.getCurrentUser();
                email=user1.getEmail();
                if(email.equals(mail1)){
                    Intent i2 = new Intent(MainActivity.this,AchivmentPost.class);
                    startActivity(i2);
                }else {
                    Intent i3 = new Intent(MainActivity.this,ShowActivity.class);
                    startActivity(i3);
                }
                break;
            case R.id.about:
                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                break;
            case R.id.developer:
//                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                Intent ide = new Intent(MainActivity.this,DeveloperPage.class);
                startActivity(ide);
                break;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(MainActivity.this, LoginPage.class);
                startActivity(I);
                Toast.makeText(getApplicationContext(),"Login to continue", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return false;
    }

    @Override
    public void itemClicked(View view, int position) {
        if (position == 0){
//            Intent i1 = new Intent(HomeActivity.this,JobseekerPosts.class);
//            startActivity(i1);
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(MainActivity.this,AndroidClub.class);
            startActivity(i1);
        }else if (position == 1){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(MainActivity.this,IOTClub.class);
            startActivity(i1);
        }else if (position == 2){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(MainActivity.this,MalaiClub.class);
            startActivity(i1);
        }else if (position == 3){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(MainActivity.this,DscClub.class);
            startActivity(i1);
        }else if (position == 4){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(MainActivity.this,CloudClub.class);
            startActivity(i1);
        }else if (position == 5){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(MainActivity.this,NullClub.class);
            startActivity(i1);
        }else if (position == 6){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(MainActivity.this,WebClub.class);
            startActivity(i1);
        }
        else if (position == 7){
//            Toast.makeText(this, "Selected is:"+position, Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(MainActivity.this,DataAnaliticsClub.class);
            startActivity(i1);
        }
    }
}