package com.lijinshan.carfuture.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.lijinshan.carfuture.R;
import com.lijinshan.carfuture.base.MxBaseActivity;
import com.lijinshan.carfuture.di.component.DaggerMainComponent;
import com.lijinshan.carfuture.di.module.MainModule;
import com.lijinshan.carfuture.mvp.contract.MainContract;
import com.lijinshan.carfuture.mvp.presenter.MainPresenter;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends MxBaseActivity<MainPresenter> implements MainContract.View {


    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


}
