package com.codesyntax.jarrion.ui.webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.codesyntax.jarrion.navigation.WebviewActivityNavigator;
import com.google.sample.cast.refplayer.R;

public class WebviewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.drawer_item_about_name);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl(getIntent().getStringExtra(WebviewActivityNavigator.EXTRA_URL));
    }
}
