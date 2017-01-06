package com.example.myapplication.M_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.transition.Transition;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by admin on 2017/1/5.
 */

public class M_Text_Gradient extends TextView {

    int mViewWidth = 0;
    int mTranslate=0;
    Matrix mGradientMatrix;
    LinearGradient mlinearGradient;

    public M_Text_Gradient(Context context) {
        super(context);
    }

    public M_Text_Gradient(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public M_Text_Gradient(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mGradientMatrix!=null){
            mTranslate+=mViewWidth/5;
            if (mTranslate>2*mViewWidth){

                mTranslate=-mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate,0);
        mlinearGradient.setLocalMatrix(mGradientMatrix);
        postInvalidateDelayed(200);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                Paint mPaint = getPaint();
                mlinearGradient = new LinearGradient(0, 0, mViewWidth, 0, new int[]{Color.BLUE, 0xffffff, Color.GREEN}, null, Shader.TileMode.CLAMP);
                mPaint.setShader(mlinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }
}
