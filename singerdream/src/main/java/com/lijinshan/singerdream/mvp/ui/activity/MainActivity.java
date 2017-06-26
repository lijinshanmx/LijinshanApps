package com.lijinshan.singerdream.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.lijinshan.singerdream.R;
import com.lijinshan.singerdream.base.MxBaseActivity;
import com.lijinshan.singerdream.di.component.DaggerMainComponent;
import com.lijinshan.singerdream.di.module.MainModule;
import com.lijinshan.singerdream.mvp.contract.MainContract;
import com.lijinshan.singerdream.mvp.presenter.MainPresenter;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends MxBaseActivity<MainPresenter> implements MainContract.View {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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
    public void initData2(Bundle savedInstanceState) {

        BmobUser bu = new BmobUser();
        bu.setUsername("lijinshan");
        bu.setPassword("123456");
        bu.setEmail("sendi@163.com");
        bu.signUp(new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser s, BmobException e) {
                if (e == null) {
                    System.out.println("注册成功:" + s.toString());
                } else {
                    e.printStackTrace();
                }
            }
        });
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
