package com.chris.horizontalbarsdemo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chris.horizontalbarsdemo.R;
import com.chris.horizontalbarsdemo.util.AppUtil;


/**
 * 单行 渐变水平柱状图
 * Created by Chris on 2017/8/14.
 */

public class ShadingBar extends LinearLayout {

    private static final String TAG = "ShadingBar";

    private Context context;

    private int DEFAULT_LENGTH = 320;

    private int TOTAL_NUM = 100;

    private int BAR_NUM = 50;

    private View bar;

    private TextView content;

    private String contentName = "";


    public ShadingBar(Context context) {
        this(context,null);
    }

    public ShadingBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();

        calculateLength();
    }

    public ShadingBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    private void init()
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view =  inflater.inflate(R.layout.shading_bar_lay, this, true);

        bar = (View)view.findViewById(R.id.inner_bar);
        content = (TextView)view.findViewById(R.id.content_name);
    }

    private void calculateLength(){

        content.setText(contentName);

        float length = (float)BAR_NUM/(float)(TOTAL_NUM+ AppUtil.dp2px(TOTAL_NUM/20))*(float) AppUtil.dp2px(DEFAULT_LENGTH);
        Log.i(TAG,"calculate bar length: "+length);
        ViewGroup.LayoutParams layoutParams = bar.getLayoutParams();
        layoutParams.width = (int)length;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        bar.setLayoutParams(layoutParams);

    }

    public void setData(int num,int totalNum,String spotName)
    {
        BAR_NUM = num;
        TOTAL_NUM = totalNum;
        contentName = spotName;
        calculateLength();
    }
}
