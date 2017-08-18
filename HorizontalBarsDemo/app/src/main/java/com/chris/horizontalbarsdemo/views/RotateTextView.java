package com.chris.horizontalbarsdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

import com.chris.horizontalbarsdemo.util.AppUtil;

/**旋转90度的TextView
 * Created by Chris on 2017/8/15.
 */

public class RotateTextView extends TextView {

    private static final int DEFAULT_VALUE_ROTATE = 0;

    private int rotate = DEFAULT_VALUE_ROTATE;

    public RotateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        rotate = 90;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(AppUtil.dp2px(10),0);
        canvas.rotate(rotate);
        canvas.translate(0,-AppUtil.dp2px(10));
        super.onDraw(canvas);
    }

}
