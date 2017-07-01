package com.lijinshan.singerdream.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.lijinshan.singerdream.R;
import com.lijinshan.singerdream.app.activity.ArticleActivity;
import com.lijinshan.singerdream.base.MxBaseActivity;
import com.lijinshan.singerdream.di.component.DaggerMainComponent;
import com.lijinshan.singerdream.di.module.MainModule;
import com.lijinshan.singerdream.mvp.contract.MainContract;
import com.lijinshan.singerdream.mvp.presenter.MainPresenter;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends MxBaseActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.btnArticle)
    Button btnArticle;

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
        btnArticle.setOnClickListener(v -> {
//            ArticleCategory articleCategory = new ArticleCategory();
//            articleCategory.setObjectId("vfCk777J");
//
//            Article article = new Article();
//            article.content = "test pointer3!";
//            article.category = articleCategory;
//
//            article.save(new SaveListener<String>() {
//                @Override
//                public void done(String s, BmobException e) {
//                    if (e == null) {
//                        Timber.i("bmob 评论发表成功");
//                    } else {
//                        Timber.i("bmob 失败：" + e.getMessage());
//                    }
//                }
//
//            });
//
//            Article.queryAllByCategory("vfCk777J", new FindListener<Article>() {
//                @Override
//                public void done(List<Article> articles, BmobException e) {
//                    if (e == null) {
//                        Timber.d("查询 Article 关联数据success");
//                    } else {
//                        Timber.e("查询 Article 关联数据failed: '%s'", e.getMessage());
//                    }
//                }
//            });

//            Article.addArticle("hahaahha1", "vfCk777J", new SaveListener<String>() {
//                @Override
//                public void done(String s, BmobException e) {
//
//                }
//            });

//            Article.deleteArticle("738870d11f", new UpdateListener() {
//                @Override
//                public void done(BmobException e) {
//
//                }
//            });
//            Article.updateArticle("LvpxNNNa", "lijinshan dahaoren11111", "vfCk777J", new UpdateListener() {
//                @Override
//                public void done(BmobException e) {
//
//                }
//            });
            ArticleActivity.startActivity(mActivity, "李金山", "34aa88e054");

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
