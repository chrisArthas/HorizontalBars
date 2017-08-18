package com.chris.horizontalbarsdemo.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.chris.horizontalbarsdemo.R;
import com.chris.horizontalbarsdemo.util.AppUtil;


/**
 * Created by win on 2017/8/15.
 */

public class CircleBars extends LinearLayout {

    private static final String TAG = "CircleBar";

    private Context context;

    private RotateTextView textView;

    private View firstBar;

    private View secondBar;

    private View thirdBar;

    private View forthBar;

    private View fifthBar;

    private View sixthBar;

    private int TOTAL_NUM = 9500;

    public CircleBars(Context context) {
        this(context,null);
    }

    public CircleBars(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleBars(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        initView();
    }

    private void initView()
    {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view  = layoutInflater.inflate(R.layout.circle_bar_lay,this,true);

        textView = (RotateTextView)view.findViewById(R.id.text_view);
        firstBar = view.findViewById(R.id.first_bar);
        secondBar = view.findViewById(R.id.second_bar);
        thirdBar = view.findViewById(R.id.third_bar);
        forthBar = view.findViewById(R.id.fouth_bar);
        fifthBar = view.findViewById(R.id.fifth_bar);
        sixthBar = view.findViewById(R.id.sixth_bar);

    }

    public void setData(ReferenceBean data, int num)
    {
        int all = num/500 * 500 + 1000;
        TOTAL_NUM = all - all/20;
        String time = data.getTime();
        int first = data.getFirst_num();
        int second = data.getSecond_num();
        int third = data.getThird_num();
        int fouth = data.getForth_num();
        int fifth = data.getFifth_num();
        int sixth = data.getSixth_num();

        textView.setText(time);

        int length = AppUtil.dp2px(300);

        float count1 = (float)first/TOTAL_NUM * (float)length;
        float count2 = (float)second/TOTAL_NUM * (float)length;
        float count3 = (float)third/TOTAL_NUM * (float)length;
        float count4 = (float)fouth/TOTAL_NUM * (float)length;
        float count5 = (float)fifth/TOTAL_NUM * (float)length;
        float count6 = (float)sixth/TOTAL_NUM * (float)length;

        setWidth(firstBar,(int)count1);
        setWidth(secondBar,(int)count2);
        setWidth(thirdBar,(int)count3);
        setWidth(forthBar,(int)count4);
        setWidth(fifthBar,(int)count5);
        setWidth(sixthBar,(int)count6);



    }

    private void setWidth(View view, int width)
    {
        startAnimation(view,width);
//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//        layoutParams.width  = width;
//        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
//        view.setLayoutParams(layoutParams);
    }

    private void startAnimation(View view, int width)
    {
        ViewWrapper viewWrapper = new ViewWrapper(view);
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(viewWrapper,"width",width);
        objectAnimator.setDuration(1000).start();
    }

    public class ViewWrapper
    {
        View view;
        ViewWrapper(View button)
        {
            this.view = button;
        }

        public void setWidth(int width)
        {
            view.getLayoutParams().width = width;
            view.requestLayout();
        }

        public int getWidth()
        {
            return  view.getLayoutParams().width;
        }

    }
}
