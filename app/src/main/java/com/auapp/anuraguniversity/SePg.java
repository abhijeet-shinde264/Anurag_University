package com.auapp.anuraguniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SePg extends AppCompatActivity {
WebView webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se_pg);
        webView1=findViewById(R.id.seweb);
        WebSettings webSettings=webView1.getSettings();
        webView1.loadUrl("https://anurag.edu.in/academics/programs/engineering/structural-engineering/");
        webSettings.setJavaScriptEnabled(true);
        webView1.setWebViewClient(new SePg.webclient());
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