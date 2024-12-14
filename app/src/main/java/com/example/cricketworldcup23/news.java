package com.example.cricketworldcup23;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class news extends AppCompatActivity {
    WebView news;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        news=(WebView) findViewById(R.id.news);
        WebSettings webSettings=news.getSettings();
        webSettings.setJavaScriptEnabled(true);
        news.setWebViewClient(new WebViewClient());
        news.loadUrl("https://www.cricbuzz.com/cricket-news");
    }
}