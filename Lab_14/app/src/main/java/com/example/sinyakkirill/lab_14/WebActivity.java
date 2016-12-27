package com.example.sinyakkirill.lab_14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.sinyakkirill.lab_14.fragments.ListExchangeRates;

public class WebActivity extends AppCompatActivity {

    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.loadUrl(ListExchangeRates.url);
    }
}
