package com.awiatori;

import static com.awiatori.PT.load;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    WebView webViewFullApp;
    public static boolean urlstatus = false;
    public ValueCallback<Uri> fdfdf;
    public Uri dsds = null;
    public ValueCallback<Uri[]> oijjccs;
    public String shda;
    public static final int icshOCS = 1;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wa);
        webViewFullApp = findViewById(R.id.webViewFullApp);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webViewFullApp, true);
        CookieManager.getInstance().setAcceptCookie(true);
        webViewFullApp.setVisibility(View.VISIBLE);
        webViewFullApp.getSettings().setAllowFileAccessFromFileURLs(true);
        webViewFullApp.getSettings().setSavePassword(true);
        webViewFullApp.getSettings().setDatabaseEnabled(true);
        webViewFullApp.getSettings().setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        webViewFullApp.getSettings().setCacheMode(android.webkit.WebSettings.LOAD_DEFAULT);
        webViewFullApp.getSettings().setAppCacheEnabled(true);
        webViewFullApp.getSettings().setLoadsImagesAutomatically(true);
        webViewFullApp.setSaveEnabled(true);
        webViewFullApp.getSettings().setMixedContentMode(0);
        webViewFullApp.setFocusable(true);
        webViewFullApp.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webViewFullApp.getSettings().setJavaScriptEnabled(true);
        webViewFullApp.getSettings().setAllowContentAccess(true);
        webViewFullApp.getSettings().setLoadWithOverviewMode(true);
        webViewFullApp.getSettings().setEnableSmoothTransition(true);
        webViewFullApp.getSettings().setUseWideViewPort(true);
        webViewFullApp.getSettings().setSaveFormData(true);
        webViewFullApp.getSettings().setAllowFileAccess(true);
        webViewFullApp.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewFullApp.getSettings().setDomStorageEnabled(true);
        webViewFullApp.setFocusableInTouchMode(true);
        webViewFullApp.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (url.contains(PT.dec("ZXJyb3I9YXBwYWZBczNm")) || url.contains(PT.dec("ZGlzYWJsZWQ="))){
                    urlstatus = true;
                    startActivity(new Intent(getApplicationContext(),PT.class));
                    finishAffinity();
                }
            }
        });
        webViewFullApp.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onShowFileChooser(WebView view,
                                             ValueCallback<Uri[]> filePath,
                                             FileChooserParams fileChooserParams) {
                if (oijjccs != null) {
                    oijjccs.onReceiveValue(null);
                }
                oijjccs = filePath;
                Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
                contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
                contentSelectionIntent.setType("*/*");
                Intent[] intentArray = new Intent[0];
                Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
                chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
                chooserIntent.putExtra(Intent.EXTRA_TITLE, PT.dec("U2VsZWN0IE9wdGlvbjo="));
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);
                startActivityForResult(chooserIntent, 1);
                return true;
            }
        });
        webViewFullApp.loadUrl(load);
    }

    @Override
    public void onBackPressed() {
        if (webViewFullApp.isFocused() && webViewFullApp.canGoBack()) {
            webViewFullApp.goBack();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != icshOCS || oijjccs == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        Uri[] results = null;
        if (resultCode == Activity.RESULT_OK) {
            if (data == null) {
                if (shda != null) {
                    results = new Uri[]{Uri.parse(shda)};
                }
            } else {
                String dataString = data.getDataString();
                if (dataString != null) {
                    results = new Uri[]{Uri.parse(dataString)};
                }
            }
        }
        oijjccs.onReceiveValue(results);
        oijjccs = null;
        if (fdfdf == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        Uri result = null;
        try {
            if (resultCode != RESULT_OK) {
                result = null;
            } else {
                result = data == null ? dsds : data.getData();
            }
        } catch (Exception e) { }
        fdfdf.onReceiveValue(result);
        fdfdf = null;
    }
}
