package com.chris.horizontalbarsdemo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chris.horizontalbarsdemo.R;
import com.chris.horizontalbarsdemo.util.AppUtil;


/**
 * Created by win on 2017/8/14.
 */

public class FiveColorBar extends LinearLayout {

    private static final String TAG = "AttentionBar";

    private Context context;

    private View best;

    private View good;

    private View normal;

    private View bad;

    private TextView content;

    private int TOTAL_LENGTH = 320;

    public FiveColorBar(Context context) {
        this(context,null);
    }

    public FiveColorBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FiveColorBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        initView();
    }

    private void initView()
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.five_color_bar_lay,this,true);
        best = view.findViewById(R.id.best);
        good = view.findViewById(R.id.good);
        normal = view.findViewById(R.id.normal);
        bad = view.findViewById(R.id.bad);
        content = (TextView)view.findViewById(R.id.content);

    }


    public void setData(String spotName, float bestNum, float goodNum, float normalNum, float badNum, float worstNum)
    {
        content.setText(spotName);

        float total = bestNum+goodNum+normalNum+badNum+worstNum;
        float bestWidth = bestNum/total* (float) AppUtil.dp2px(TOTAL_LENGTH);
        float goodWidth = goodNum/total* (float)AppUtil.dp2px(TOTAL_LENGTH);
        float normalWidth = normalNum/total* (float)AppUtil.dp2px(TOTAL_LENGTH);
        float badWidth = badNum/total* (float)AppUtil.dp2px(TOTAL_LENGTH);

        setWidth(best,(int)bestWidth);
        setWidth(good,(int)goodWidth);
        setWidth(normal,(int)normalWidth);
        setWidth(bad,(int)badWidth);
    }

    private void setWidth(View view, int width)
    {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width  = width;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        view.setLayoutParams(layoutParams);
    }
}
