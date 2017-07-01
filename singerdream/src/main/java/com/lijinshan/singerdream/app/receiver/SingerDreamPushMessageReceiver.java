package com.lijinshan.singerdream.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.bmob.push.PushConstants;
import timber.log.Timber;

/**
 * Created by lijinshan on 2017/6/27.
 */

public class SingerDreamPushMessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PushConstants.ACTION_MESSAGE)) {
            Timber.tag("bmob").d("客户端收到推送内容：" + intent.getStringExtra("msg"));
        }
    }
}
