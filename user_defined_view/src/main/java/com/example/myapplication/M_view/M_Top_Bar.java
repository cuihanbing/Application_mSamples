package com.example.myapplication.M_view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * Created by admin on 2017/1/5.
 */

public class M_Top_Bar extends RelativeLayout {
    TextView mTitleView;
    Button mLeftButton;
    Button mRightButton;
    MtopbarClickListener mtopbarlistener;

    String mTitle;
    float mTitleSize;
    int mTitleTextColor;

    String mLeftText;
    Drawable mLeftBackground;
    int mLeftTextColor;

    String mRightText;
    Drawable mRightBackground;
    int mRightTextColor;

    LayoutParams mTitleParams;
    LayoutParams mleftParams;
    LayoutParams mRightParams;

    public M_Top_Bar(Context context) {
        super(context);

    }

    public M_Top_Bar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public M_Top_Bar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.M_Top_Bar);//利用TypedArray获取attrs属性值

        mTitle = ta.getString(R.styleable.M_Top_Bar_title_Text);
        mTitleSize = ta.getDimension(R.styleable.M_Top_Bar_titleTextSize, 10);
        mTitleTextColor = ta.getColor(R.styleable.M_Top_Bar_titleTextColor_, 0);

        mLeftText = ta.getString(R.styleable.M_Top_Bar_leftText);
        mLeftTextColor = ta.getColor(R.styleable.M_Top_Bar_leftTextColor, 0);
        mLeftBackground = ta.getDrawable(R.styleable.M_Top_Bar_leftBackGround);

        mRightText = ta.getString(R.styleable.M_Top_Bar_rightText);
        mRightTextColor = ta.getColor(R.styleable.M_Top_Bar_rightTextColor, 0);
        mRightBackground = ta.getDrawable(R.styleable.M_Top_Bar_rightBackGround);
        //获取完TypedArray属性值后，回收资源
        ta.recycle();


        //获得组件元素
        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleView = new TextView(context);

        //为组件赋值，值来源于attrs
        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleSize);

        mLeftButton.setText(mLeftText);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setTextColor(mLeftTextColor);

        mRightButton.setText(mRightText);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setTextColor(mRightTextColor);

        //为组件布局

        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        //添加到ViewGroup
        addView(mTitleView, mTitleParams);


        mleftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mleftParams.addRule(RelativeLayout.ALIGN_LEFT, TRUE);
        //添加到ViewGroup
        addView(mLeftButton, mleftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        //添加到ViewGroup
        addView(mRightButton, mRightParams);



       mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mtopbarlistener.leftClick();
            }
        });
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mtopbarlistener.rightClick();
            }
        });


    }


    //接口对象，实现回调机制，再回调方法中，通过映射的接口对象调用接口中的方法而不用考虑如何实现，具体实现由调用者去创建

    public interface MtopbarClickListener {
        //左按钮点击事件
        void leftClick();

        //右按钮点击事件
        void rightClick();
    }


    public void setOnmTopBarClickListener(MtopbarClickListener mtopbarlistener) {//?????????
        this.mtopbarlistener = mtopbarlistener;
    }



    public void setButtonVisible(int id,boolean flag){//动态控制左右button是否显示 mtopbar.setButtonVisible(0,true)
        if (flag){
            if (id==0){
                mLeftButton.setVisibility(View.VISIBLE);
            }else {
                mRightButton.setVisibility(VISIBLE);
            }

        }else {
            if (id==0){
                mLeftButton.setVisibility(GONE);
            }else {
                mRightButton.setVisibility(GONE);
            }
        }
    }


}
