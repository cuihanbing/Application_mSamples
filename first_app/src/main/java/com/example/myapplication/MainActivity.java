package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {
    private String objectId="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //提供以下两种方式进行初始化操作：

        //第一：默认初始化
//        Bmob.initialize(getApplication(), "2641c9e91e8bd9b23d8c3bf657041a84");

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        BmobConfig config =new BmobConfig.Builder(this)
        //设置appkey
        .setApplicationId("2641c9e91e8bd9b23d8c3bf657041a84")
        //请求超时时间（单位为秒）：默认15s
        .setConnectTimeout(30)
        //文件分片上传时每片的大小（单位字节），默认512*1024
        .setUploadBlockSize(1024*1024)
        //文件的过期时间(单位为秒)：默认1800s
        .setFileExpiration(2500)
        .build();
       Bmob.initialize(config);

GameScore gameScore=new GameScore();
        gameScore.setPlayerName("jessie");
        gameScore.setScore(80);
        gameScore.setAge(20);
        gameScore.setHeight(180);
        gameScore.setFamilyNumber(4);
        gameScore.setIsPay(true);
        gameScore.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    Toast.makeText(getApplication(),"创建成功",Toast.LENGTH_SHORT).show();
                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });


final Animals animals=new Animals();
        animals.setCat("猫");
        animals.setDog("狗");
        animals.setPig("猪");
        animals.setFish("鱼");
        animals.setobjectId("123456789");
animals.save(new SaveListener<String>() {
    @Override
    public void done(String s, BmobException e) {
        if(e==null){
            Toast.makeText(getApplication(),"2创建成功"+animals.getObjectId(),Toast.LENGTH_SHORT).show();
        }else{
            Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
        }
    }
});

    }

}
