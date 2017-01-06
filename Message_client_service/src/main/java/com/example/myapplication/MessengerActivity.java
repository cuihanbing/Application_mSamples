package com.example.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.data;
import static android.R.attr.tabStripEnabled;

public class MessengerActivity extends AppCompatActivity {
    private final String TAG = "MessengerActivity";
    private Messenger mService;
    Message msg;
    Bundle data;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = new Messenger(service);
            msg = Message.obtain(null, MyConstants.MSG_FROM_CLIENT);
            data = new Bundle();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private Messenger mGetReplyMessenger=new Messenger(new  MessengerHandle());
    private class MessengerHandle extends Handler  {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MyConstants.MSG_FROM_SERVICE:
                    Toast.makeText(MessengerActivity.this,msg.getData().getString("reply"),Toast.LENGTH_LONG).show();
            }
            super.handleMessage(msg);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//绑定服务
        Intent intent = new Intent(this, MessengerService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);


        Button button = (Button) findViewById(R.id.bt_hello);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data.putString("msg", "这里是客户端发送的的数据");
                msg.replyTo=mGetReplyMessenger;
                msg.setData(data);

                try {
                    mService.send(msg);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        super.onDestroy();
    }
}
