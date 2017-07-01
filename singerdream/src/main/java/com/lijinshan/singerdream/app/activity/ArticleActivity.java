package com.lijinshan.singerdream.app.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;

import com.lijinshan.singerdream.R;
import com.lijinshan.singerdream.app.model.Article;
import com.lijinshan.singerdream.app.utils.CommonUtils;
import com.lijinshan.singerdream.base.MxBaseActivity;
import com.lijinshan.singerdream.widget.jsbridge.BridgeWebView;

import butterknife.BindView;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

public class ArticleActivity extends MxBaseActivity {


    @BindView(R.id.BridgeWebView)
    BridgeWebView mBridgeWebView;

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_article;
    }

    public static void startActivity(Activity activity, String title, String aid) {
        Intent intent = new Intent(activity, ArticleActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("aid", aid);
        activity.startActivity(intent);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initData2(Bundle savedInstanceState) {
        String title = getIntent().getStringExtra("title");
        String aid = getIntent().getStringExtra("aid");

        setTitle(title);

        WebSettings setting = mBridgeWebView.getSettings();
        setting.setJavaScriptEnabled(true);
        setting.setJavaScriptCanOpenWindowsAutomatically(true);
        setting.setAllowFileAccess(true);
        setting.setSupportZoom(false);
        setting.setBuiltInZoomControls(false);
        setting.setUseWideViewPort(true);
        setting.setLoadWithOverviewMode(true);
        setting.setAppCacheEnabled(true);
        setting.setDomStorageEnabled(true);
        setting.setDatabaseEnabled(true);
        setting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        setting.setBlockNetworkImage(false);

        Article.queryArticle(aid, new QueryListener<Article>() {
            @Override
            public void done(Article article, BmobException e) {
                CommonUtils.webviewLoadData(mBridgeWebView, article.content);
            }
        });

    }

}
