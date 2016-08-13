package edu.udayton.myemailapp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        // TODO: Implement this method
        view.loadUrl(url);
        return true;
    }
}
