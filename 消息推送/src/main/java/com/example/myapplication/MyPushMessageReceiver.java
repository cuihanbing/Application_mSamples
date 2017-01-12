package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import cn.bmob.push.PushConstants;

/**
 * Created by admin on 2017/1/10.
 */

public class MyPushMessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("bmob", "客户端收到推送内容："+intent.getStringExtra("msg"));
        // TODO Auto-generated method stub
        if(intent.getAction().equals(PushConstants.ACTION_MESSAGE)){
            Log.d("bmob", "客户端收到推送内容："+intent.getStringExtra("msg"));

            Toast.makeText(context,"客户端收到推送内容："+intent.getStringExtra("msg"),Toast.LENGTH_SHORT).show();
        }

    }

}
