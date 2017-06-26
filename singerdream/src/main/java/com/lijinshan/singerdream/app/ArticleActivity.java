package com.lijinshan.singerdream.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;

import com.lijinshan.singerdream.R;
import com.lijinshan.singerdream.app.utils.ArticleUtils;
import com.lijinshan.singerdream.base.MxBaseActivity;
import com.lijinshan.singerdream.widget.jsbridge.BridgeWebView;

import butterknife.BindView;

public class ArticleActivity extends MxBaseActivity {


    @BindView(R.id.BridgeWebView)
    BridgeWebView mBridgeWebView;

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_article;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initData2(Bundle savedInstanceState) {
        String title = getIntent().getStringExtra("title");
        String aid = getIntent().getStringExtra("aid");

        setTitle("haha");

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

        String data = "<!DOCTYPE html>\n" +
                "<html>\n" +
                " <head> \n" +
                "  <meta charset=\"utf-8\" /> \n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" /> \n" +
                "  <link rel=\"stylesheet\" href=\"css/amazeui.min.css\" /> \n" +
                "  <style>%s</style>" +
                "  </head> \n" +
                "  <body> \n" +
                "  <div id=\"content\"> \n" +
                "   <p>很多朋友在唱高音的时候都会遇到破音这个状况，从而导致不敢去唱高音，时间长了自己的声音就会很平淡没有高位置的音色了，所以我们今天就来攻破这个难题。<br /></p> \n" +
                "   <p>怎么解决，其实就是怎么能够唱好高音，我们需要做到两点技巧： <br /> <br /> 1.降低喉位 <br /> 2.打开牙关 </p> \n" +
                "   <p>降低喉位大家也知道，我们在高音的时候必须要降低喉结的位置才能够不扯嗓子，我们唱歌如果扯着嗓子后果大家也知道对吧。降低喉位就是要放松喉咙，从而更轻松的去唱高音。</p> \n" +
                "   <p>打开牙关就是把气息通往高位置共鸣的通道打通，牙关其实可以理解为一个阀门开关，打开它气息就可以通往高位置共鸣腔了，这样我们就可以唱好高音了，气息直接往腔体上打，怎么打都不会破音。</p> \n" +
                "   <p> 所以说想要唱歌不破音，这两点是必须要做到的。</p> \n" +
                "   <img class=\"am-img-responsive\" src=\"http://s.amazeui.org/media/i/demos/bing-1.jpg\" /> \n" +
                "  </div> \n" +
                "  <script src=\"js/jquery.min.js\"></script> \n" +
                "  <script src=\"js/amazeui.min.js\"></script>  \n" +
                " </body>\n" +
                "</html>";

        mBridgeWebView.loadDataWithBaseURL("file:///android_asset/", String.format(data, ArticleUtils.getArticleCssStyle(this)), "text/html", "htf-8", null);
    }

}
