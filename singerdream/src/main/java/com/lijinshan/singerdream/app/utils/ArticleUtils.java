package com.lijinshan.singerdream.app.utils;

import android.content.Context;

import static com.lijinshan.singerdream.app.utils.ConfigUtils.ARTICLE_STYLE_PREFERENCE_NAME;

/**
 * Created by lijinshan on 2017/6/26.
 */

public class ArticleUtils {
    private static final String ArticleCssStyle = "body {margin:0px;font-size: %srem;line-height: %s;color: %s;background-color: %s;}";
    private static final String ArticleDefaultFontSize = "1.6";
    private static final String ArticleDefaultLineHeight = "1.5";
    private static final String ArticleTextColor = "#333";
    private static final String ArticleBackgroundColor = "#fff";

    public static void setTextSize(Context context, float textSize) {
        new SharePreferenceUtil(context, ARTICLE_STYLE_PREFERENCE_NAME).putString("ArticleDefaultFontSize", String.valueOf(textSize));
    }

    public static void setLineHeight(Context context, float lineHeight) {
        new SharePreferenceUtil(context, ARTICLE_STYLE_PREFERENCE_NAME).putString("ArticleDefaultLineHeight", String.valueOf(lineHeight));
    }

    public static void setTextColor(Context context, String textColor) {
        new SharePreferenceUtil(context, ARTICLE_STYLE_PREFERENCE_NAME).putString("ArticleTextColor", textColor);
    }

    public static void setBackgroundColor(Context context, String backgroundColor) {
        new SharePreferenceUtil(context, ARTICLE_STYLE_PREFERENCE_NAME).putString("ArticleBackgroundColor", backgroundColor);
    }

    public static void resetDefault(Context context) {
        SharePreferenceUtil articleStyleSPUtil = new SharePreferenceUtil(context, ARTICLE_STYLE_PREFERENCE_NAME);
        articleStyleSPUtil.putString("ArticleDefaultFontSize", ArticleDefaultFontSize);
        articleStyleSPUtil.putString("ArticleDefaultLineHeight", ArticleDefaultLineHeight);
        articleStyleSPUtil.putString("ArticleTextColor", ArticleTextColor);
        articleStyleSPUtil.putString("ArticleBackgroundColor", ArticleBackgroundColor);
    }

    public static String getArticleCssStyle(Context context) {
        SharePreferenceUtil articleStyleSPUtil = new SharePreferenceUtil(context, ARTICLE_STYLE_PREFERENCE_NAME);
        String defaultFontSize = articleStyleSPUtil.getString("ArticleDefaultFontSize", ArticleDefaultFontSize);
        String defaultLineHeight = articleStyleSPUtil.getString("ArticleDefaultLineHeight", ArticleDefaultLineHeight);
        String defaultTextColor = articleStyleSPUtil.getString("ArticleTextColor", ArticleTextColor);
        String defaultBackgroundColor = articleStyleSPUtil.getString("ArticleBackgroundColor", ArticleBackgroundColor);

        return String.format(ArticleCssStyle, defaultFontSize, defaultLineHeight, defaultTextColor, defaultBackgroundColor);
    }


}
