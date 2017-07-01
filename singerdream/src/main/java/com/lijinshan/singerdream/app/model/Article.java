package com.lijinshan.singerdream.app.model;

import android.text.TextUtils;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by lijinshan on 2017/7/1.
 */

public class Article extends BmobObject {
    public String content;
    public ArticleCategory category;

    public static void queryAllByCategory(String articleCategoryObjectId, FindListener<Article> findListener) {
        BmobQuery<Article> query = new BmobQuery<Article>();
        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setObjectId(articleCategoryObjectId);
        query.addWhereEqualTo("category", new BmobPointer(articleCategory));
        query.include("category");
        query.findObjects(findListener);
    }

    public static void addArticle(String content, SaveListener<String> saveListener) {
        addArticleWithCategory(content, null, saveListener);
    }

    public static void addArticleWithCategory(String content, String articleCategoryObjectId, SaveListener<String> saveListener) {

        Article article = new Article();
        article.content = content;

        if (!TextUtils.isEmpty(articleCategoryObjectId)) {
            ArticleCategory articleCategory = new ArticleCategory();
            articleCategory.setObjectId(articleCategoryObjectId);
            article.category = articleCategory;
        }
        article.save(saveListener);
    }

    public static void removeArticleRelation(String articleObjectId, UpdateListener updateListener) {
        Article article = new Article();
        article.remove("category");
        article.update(articleObjectId, updateListener);
    }

    public static void deleteArticle(String articleObjectId, UpdateListener updateListener) {
        Article article = new Article();
        article.delete(articleObjectId, updateListener);
    }

    public static void updateArticle(String articleObjectId, String content, UpdateListener updateListener) {
        updateArticle(articleObjectId, content, null, updateListener);
    }

    public static void updateArticle(String articleObjectId, String content, String articleCategoryObjectId, UpdateListener updateListener) {
        if (content == null) return;
        Article article = new Article();
        article.content = content;
        if (!TextUtils.isEmpty(articleCategoryObjectId)) {
            ArticleCategory articleCategory = new ArticleCategory();
            articleCategory.setObjectId(articleCategoryObjectId);
            article.category = articleCategory;
        }
        article.update(articleObjectId, updateListener);
    }

    public static void queryArticle(String articleObjectId, QueryListener<Article> queryListener) {
        BmobQuery<Article> query = new BmobQuery<>();
        query.getObject(articleObjectId, queryListener);
    }
}
