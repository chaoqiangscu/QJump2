package com.example.lcq.qjump2.utils;

/**
 * Created by Administrator on 2018/3/14.
 * 要用的时候调用ToastUtil.showToast(context, msg, duration);
 */

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.widget.Toast;


public class ToastUtil {
    private static Toast mToast;

    public static void showToast(Context context, int resId, int duration) {
        showToast(context, context.getString(resId), duration);
    }

    public static void showToast(Context context, String msg, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, duration);
        } else {
            mToast.setText(msg);
        }
        mToast.setGravity(Gravity.CENTER, 0, 0);    //设置在中间显示
        mToast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /**
                 *要执行的操作
                 */
                mToast.cancel();
            }
        }, 300);
    }
}


