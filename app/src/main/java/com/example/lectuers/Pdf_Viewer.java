package com.example.lectuers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Pdf_Viewer extends AppCompatActivity {
WebView webView;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf__viewer);
        webView =(WebView)findViewById(R.id.webview);
        progressBar=(ProgressBar)findViewById(R.id.Progress);
        progressBar.setVisibility(View.VISIBLE);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.setWebChromeClient(new WebChromeClient());
        Intent intent = getIntent();
        final int position = intent.getIntExtra("position",0);
       webView.setWebViewClient(new WebViewClient(){
           @Override
           public void onPageFinished(WebView view, String url) {
                       webView.loadUrl("javascript:(function() {" +
                               "document.querySelector('[role=\"toolbar\"]').remove();}) ()");
               progressBar.setVisibility(View.GONE);
           }
       });

       webView.loadUrl("https://docs.google.com/gview?embedded=true&url="+MainActivity.list.get(position).getPdfur());
    }

    }

