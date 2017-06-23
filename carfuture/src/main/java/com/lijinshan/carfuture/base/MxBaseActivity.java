package com.lijinshan.carfuture.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;

import com.gyf.barlibrary.ImmersionBar;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.mvp.IPresenter;
import com.lijinshan.carfuture.R;
import com.lijinshan.carfuture.app.interf.ITranslucentStatusBar;

/**
 * Created by lijinshan on 2017/6/23.
 */

public abstract class MxBaseActivity<P extends IPresenter> extends BaseActivity<P> implements ITranslucentStatusBar {

    protected Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
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
}
