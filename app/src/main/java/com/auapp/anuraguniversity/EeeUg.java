package com.auapp.anuraguniversity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class EeeUg extends AppCompatActivity {

    WebView webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eee_ug);
   webView1=findViewById(R.id.eeewed);
    WebSettings webSettings=webView1.getSettings();
        webView1.loadUrl("https://anurag.edu.in/academics/programs/engineering/electrical-electronics-engineering/");
        webSettings.setJavaScriptEnabled(true);
        webView1.setWebViewClient(new EeeUg.webclient());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Electrical and Electronics Engineering");
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
public class webclient extends WebViewClient
{
    @Override
    public void onPageStarted (WebView view, String url, Bitmap fevicon)
    {
        super.onPageStarted(view,url,fevicon);
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view,String url)
    {
        view.loadUrl(url);
        return true;
    }
}

    @Override
    public void onBackPressed() {
        if(webView1.canGoBack())
        {
            webView1.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}