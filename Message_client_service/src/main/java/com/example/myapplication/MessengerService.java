package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by admin on 2017/1/4.
 */

public class MessengerService extends Service {
    private static final String TAG="MessengerService";

    private static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MyConstants.MSG_FROM_CLIENT:
                    Log.d(TAG,msg.getData().getString("msg"));

                    //回复客户端
                    Messenger messenger_replay=msg.replyTo;
                    Message reply_message=Message.obtain(null,MyConstants.MSG_FROM_SERVICE);
                    Bundle bundle=new Bundle();
                    bundle.putString("reply","收到数据--来自service");
                    reply_message.setData(bundle);
                    try {
                        messenger_replay.send(reply_message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }

                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    }
    private final Messenger mMessenger =new Messenger(new MessengerHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }
}

