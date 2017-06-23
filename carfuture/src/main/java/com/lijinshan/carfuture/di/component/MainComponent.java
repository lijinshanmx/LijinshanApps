package com.lijinshan.carfuture.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;
import com.lijinshan.carfuture.di.module.MainModule;
import com.lijinshan.carfuture.mvp.ui.activity.MainActivity;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}