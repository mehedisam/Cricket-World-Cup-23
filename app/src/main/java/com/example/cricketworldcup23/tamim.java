package com.example.cricketworldcup23;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class tamim extends AppCompatActivity {
    WebView tamim;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamim);
        tamim=(WebView) findViewById(R.id.web);
        WebSettings webSettings=tamim.getSettings();
        webSettings.setJavaScriptEnabled(true);
        tamim.setWebViewClient(new WebViewClient());
        tamim.loadUrl("https://www.cricbuzz.com/profiles/612/tamim-iqbal");
    }
}