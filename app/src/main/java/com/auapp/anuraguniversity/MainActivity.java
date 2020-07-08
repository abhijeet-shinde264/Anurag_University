package com.auapp.anuraguniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout dLayout;
    ActionBarDrawerToggle mToggle;
    private FirebaseAuth mAuth;
    String currentuserid;
    String email1;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        currentuserid = mAuth.getCurrentUser().getUid();
        FirebaseUser user = mAuth.getCurrentUser();
        email = user.getEmail();
//        email=mAuth.getCurrentUser().getEmail();
        //email=mAuth.getCurrentUser().getEmail();
        dLayout = findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(MainActivity.this,dLayout,R.string.open,R.string.close);
        dLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nview);
        navigationView.setNavigationItemSelectedListener(this);
//        String mail = "17h61a0561@cvsr.ac.in";
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.nav_menu,menu);
//        MenuItem mi1 =menu.findItem(R.id.showevents);
//        MenuItem mi2 = menu.findItem(R.id.addevents);
//        final String mail=mAuth.getCurrentUser().getEmail();
//        final String email="abhijeetshinde1999@gmail.com";
//        if (mail.equals(email)){
//            mi1.setVisible(true);
//            mi2.setVisible(true);
//        }
//        return true;
//    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id =menuItem.getItemId();
//        String mail = "17h61a0561@cvsr.ac.in";
        mAuth = FirebaseAuth.getInstance();
        switch (id){
            case R.id.clubs:
//                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                Intent i4 = new Intent(MainActivity.this,Clubs.class);
                startActivity(i4);
                break;
            case R.id.chapters:
                startActivity(new Intent(MainActivity.this,Chapters.class));
                //Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                break;
            case R.id.event:
                final String mail=mAuth.getCurrentUser().getEmail();
                final String email="abhijeetshinde1999@gmail.com";
                if (mail.equals(email)){
                    startActivity(new Intent(MainActivity.this,EventsOptions.class));
                }else{
                    //Toast.makeText(this, "Sorry ur not admin", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,EventRetrival.class));
                }
                break;
            case R.id.placment:
//                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Placement.class));
                break;
            case R.id.course:
                startActivity(new Intent(MainActivity.this,DisplayCourses.class));
                break;
            case R.id.inteship:
                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                break;
            case R.id.map:
                Intent i1 = new Intent(MainActivity.this,MapActivity.class);
                startActivity(i1);
                break;
            case R.id.achivements:
                Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                startActivity(new Intent(MainActivity.this,AboutPage.class));
                //Toast.makeText(this, "Clicked:"+menuItem, Toast.LENGTH_SHORT).show();
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
}