package com.lijinshan.singerdream.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/**
 * Created by lijinshan on 2017/6/26.
 */

public class ActivityUtils {

    public static void startActivity(Context context, Class activity, String title) {
        Intent intent = new Intent(context, activity);
        if (!TextUtils.isEmpty(title)) {
            intent.putExtra("title", title);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Class activity) {
        startActivity(context, activity, null);
    }
}
