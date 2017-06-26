package com.lijinshan.singerdream.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.mvp.IPresenter;
import com.lijinshan.singerdream.R;
import com.lijinshan.singerdream.app.interf.ITranslucentStatusBar;

import butterknife.BindView;
import cn.bmob.v3.Bmob;

/**
 * Created by lijinshan on 2017/6/23.
 */

public abstract class MxBaseActivity<P extends IPresenter> extends BaseActivity<P> implements ITranslucentStatusBar {

    protected Activity mActivity;
    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.toolbar_title)
    TextView mToolBarTitle;
    @BindView(R.id.toolbar_back)
    ImageView mToolBarBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //执行在initData之前
        //第一：默认初始化
        super.onCreate(savedInstanceState);
        mActivity = this;
        Bmob.initialize(this, "53f95fb3421e2da6c35c1051c1400163", "bmob");
        initData2(savedInstanceState);

        String title = getIntent().getStringExtra("title");
        setTitle(title);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolBarBack.setOnClickListener(v -> {
            this.finish();
        });
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        if (!TextUtils.isEmpty(title)) {
            mToolBarTitle.setText(title);
        }
    }

    public void hideTitleBar() {
        mToolBar.setVisibility(View.GONE);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(R.layout.activity_base);
        // instance view stub
        ViewStub vsContent = (ViewStub) findViewById(R.id.ViewStubContentView);
        vsContent.setLayoutResource(layoutResID);
        vsContent.inflate();
        // status bar
        initTranslucentStatusBar(this);
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public boolean enableTranslucentStatusBar() {
        return true;
    }

    @Override
    public boolean needAdjustAssociatedViews() {
        return false;
    }

    @Override
    public void adjustAssociatedView() {
        // do nothing.
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (enableTranslucentStatusBar()) {
            ImmersionBar.with(this).destroy();
        }
    }

    private void initTranslucentStatusBar(Activity activity) {
        if (enableTranslucentStatusBar()) {
            ImmersionBar immersionBar = ImmersionBar.with(activity);
            if (needAdjustAssociatedViews()) {
                adjustAssociatedView();
            } else {
                View statusBarView = findViewById(R.id.statusBar);
                immersionBar.statusBarView(statusBarView);
            }
            immersionBar.init();
        }
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    public abstract void initData2(Bundle savedInstanceState);
}
