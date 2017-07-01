package com.lijinshan.singerdream.app.utils;

import android.webkit.WebView;

import java.util.List;

/**
 * Created by lijinshan on 2017/6/23.
 */

public class CommonUtils {

    public static boolean notEmpty(List list) {
        if (list == null || list.size() == 0)
            return false;
        return true;
    }

    public static void webviewLoadData(WebView webView, String data) {
        webView.loadDataWithBaseURL("file:///android_asset/", String.format(data, ArticleUtils.getArticleCssStyle(webView.getContext())), "text/html", "htf-8", null);
    }
}
