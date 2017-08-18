package com.chris.horizontalbarsdemo.util;

import com.chris.horizontalbarsdemo.App;

/**
 * Created by win on 2017/8/18.
 */

public class AppUtil {

    public static int dp2px(float dpValue) {
        final float scale = App.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
