package com.example.myapplication;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.bmob.newim.BmobIM;
import cn.bmob.newim.event.MessageEvent;
import cn.bmob.newim.event.OfflineMessageEvent;
import cn.bmob.newim.listener.BmobIMMessageHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //NewIM初始化
        BmobIM.init(this);
        //注册消息接收器
        BmobIM.registerDefaultMessageHandler(new DemoMessageHandler(this));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public class DemoMessageHandler extends BmobIMMessageHandler {


        public DemoMessageHandler(MainActivity mainActivity) {

        }

        @Override
        public void onMessageReceive(final MessageEvent event) {
            //当接收到服务器发来的消息时，此方法被调用
        }

        @Override
        public void onOfflineReceive(final OfflineMessageEvent event) {
            //每次调用connect方法时会查询一次离线消息，如果有，此方法会被调用
        }
    }


}
