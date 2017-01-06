package com.example.myapplication.M_view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by admin on 2017/1/5.
 */

public class M_View extends View {
    public M_View(Context context) {
        super(context);
    }

    public M_View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    private int measureWidth(int measureSpec){
        int result=0;
        int specMode=MeasureSpec.getMode(measureSpec);
        int specSize=MeasureSpec.getSize(measureSpec);
        if(specMode==MeasureSpec.EXACTLY){
            return specSize;
        }else {
            result= 400;
            if (specMode==MeasureSpec.AT_MOST){
                result= Math.min(result,specSize);
            }
        }
        return result;
    }
    private int measureHight(int measureSpec){
        int result=0;
        int specMode=MeasureSpec.getMode(measureSpec);
        int specSize=MeasureSpec.getSize(measureSpec);
        if(specMode==MeasureSpec.EXACTLY){
            return specSize;
        }else {
            result= 200;
            if (specMode==MeasureSpec.AT_MOST){
                result= Math.min(result,specSize);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {//自定义view是=时通常重写方法来绘制View显示的内容，如果该View需要使用wrap__content还必须重写onMeasure方法
                                           //另外通过自定义attrs属性，还可以设置新的属性配置

        super.onDraw(canvas);
    }
}
