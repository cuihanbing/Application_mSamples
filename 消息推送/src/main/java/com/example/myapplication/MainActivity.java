package com.example.myapplication;

import android.content.IntentFilter;
import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobPushManager;

public class MainActivity extends AppCompatActivity {
    BmobPushManager bmobPushManager;

    String APPID="bf03acf61c0d055c8f5de8a60d92c2f4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化BmobSDK
        Bmob.initialize(this, "bf03acf61c0d055c8f5de8a60d92c2f4");
        // 使用推送服务时的初始化操作
        BmobInstallation.getCurrentInstallation(this).save();
        // 启动推送服务
        BmobPush.startWork(this);

//        Bmob.initialize(this, APPID);
//        // 使用推送服务时的初始化操作
//        BmobInstallation.getCurrentInstallation(this).save();
//
//        // 启动推送服务
//        BmobPush.startWork(this);
//
//        // 创建推送消息的对象
//        bmobPushManager = new BmobPushManager(this);
//        bmobPushManager.pushMessageAll("这是给所有设备推送的一条消息。");
MyPushMessageReceiver myPushMessageReceiver=new MyPushMessageReceiver();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("cn.bmob.push.action.MESSAGE");
        registerReceiver(myPushMessageReceiver,intentFilter);
    }




}
