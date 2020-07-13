package com.auapp.anuraguniversity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PharPhd extends AppCompatActivity {
WebView webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phar_phd);
        webView1=findViewById(R.id.phphd);
        WebSettings webSettings=webView1.getSettings();
        webView1.loadUrl("https://anurag.edu.in/academics/programs/pharmacy/pharmacy-phd/");
        webSettings.setJavaScriptEnabled(true);
        webView1.setWebViewClient(new PharPhd.webclient());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Pharmacy");
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