package com.example.myapplication.M_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by admin on 2017/1/5.
 */

public class M_textView extends TextView {


    Paint mPaint1;
    Paint mPaint2;



    public M_textView(Context context) { //在构造方法中完成画笔等、的 初始化工作
        super(context);

        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    public M_textView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    public M_textView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //回调父类方法前，实现自己的逻辑
        //绘制外层矩形
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);

        //绘制内层矩形
        canvas.drawRect(10, 10, getMeasuredWidth() -
                10, getMeasuredHeight() - 10, mPaint2);
        canvas.save();

        canvas.translate(60, 35);//绘制文字前平移像素
        //回调父类方法


        super.onDraw(canvas);//回调父类的onDraw方法(包含绘制text文字)
        canvas.restore();
    }



}
