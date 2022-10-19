package com.example.prueba01dsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        webView= (WebView) findViewById(R.id.webView);

        String url = getIntent().getStringExtra("web");

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("http://"+ url);



    }
    public void cerrar(View view){
        Intent i = new Intent(this, SecondFragment.class);
        startActivity(i);

    }
}