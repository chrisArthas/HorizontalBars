package com.chris.horizontalbarsdemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chris.horizontalbarsdemo.R;
import com.chris.horizontalbarsdemo.views.CircleBars;
import com.chris.horizontalbarsdemo.views.ReferenceBean;

/**
 * Created by win on 2017/8/18.
 */

public class CirclesBarsFragment extends Fragment{


    private CircleBars circleBars;

    ReferenceBean bean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.circle_bar_fragment_lay,null,true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        circleBars = (CircleBars)view.findViewById(R.id.circle_bars);
        initData();

        circleBars.post(new Runnable() {
            @Override
            public void run() {
                circleBars.setData(bean,10000);
            }
        });
    }

    private void initData()
    {
         bean = new ReferenceBean();

        bean.setFirst_num(6000);

        bean.setSecond_num(8300);

        bean.setThird_num(7900);

        bean.setForth_num(7600);

        bean.setFifth_num(9000);

        bean.setSixth_num(9230);

        bean.setTime("2017-08");
    }
}
