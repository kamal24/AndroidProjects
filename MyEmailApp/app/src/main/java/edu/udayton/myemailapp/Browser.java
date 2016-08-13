package edu.udayton.myemailapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends AppCompatActivity implements View.OnClickListener{
    WebView wv;
    EditText et;
    @Override
    public void onClick(View p1)
    {
        // TODO: Implement this method
        switch(p1.getId()){
            case R.id.go:
                String url=et.getText().toString();
                wv.loadUrl(url);

                InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(et.getWindowToken(),0);
                break;

            case R.id.goBack:
                wv.goBack();
                break;

            case R.id.forward:
                wv.goForward();
                break;

            case R.id.clear:
                wv.clearHistory();
                break;

            case R.id.refresh:
                wv.reload();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        setupBrowser();
    }

    private void setupBrowser()
    {
        // TODO: Implement this method
        wv=(WebView) findViewById(R.id.web);
        et=(EditText) findViewById(R.id.url);

        Button go=(Button) findViewById(R.id.go);
        Button goBack=(Button) findViewById(R.id.goBack);
        Button forward=(Button) findViewById(R.id.forward);
        Button refresh=(Button) findViewById(R.id.refresh);
        Button clear=(Button) findViewById(R.id.clear);

        go.setOnClickListener(this);
        goBack.setOnClickListener(this);
        forward.setOnClickListener(this);
        refresh.setOnClickListener(this);
        clear.setOnClickListener(this);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setAppCacheEnabled(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.getSettings().setLoadWithOverviewMode(true);

        String url="http://www.google.com";
        wv.setWebViewClient(new ViewClient());
        wv.loadUrl(url);
    }
}
