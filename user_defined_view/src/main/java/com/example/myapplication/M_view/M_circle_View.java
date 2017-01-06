package com.example.myapplication.M_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by admin on 2017/1/5.
 */

public class M_circle_View extends View{
    private Paint mPaint_cicle=new Paint();
    private Paint mPaint_Rect=new Paint();
    private Paint mPaint_text=new Paint();

    private int mColor= Color.GREEN;

    public M_circle_View(Context context) {
        super(context);
        init();
    }

    public M_circle_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public M_circle_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int mWith=getWidth();
        int mHight=getHeight();
       int radius=Math.min(mWith,mHight)/2;
        mPaint_cicle.setStyle(Paint.Style.STROKE);
        mPaint_cicle.setStrokeWidth(20);
        mPaint_cicle.setAntiAlias(true);//抗锯齿


        canvas.drawCircle(mWith/2,mHight/2,radius,mPaint_cicle);



        canvas.drawText("hello",0,5,150,100,mPaint_text);



    }

    public void init(){
        mPaint_cicle.setColor(mColor);
    }
}
