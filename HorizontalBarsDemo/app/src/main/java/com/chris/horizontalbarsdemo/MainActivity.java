package com.chris.horizontalbarsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.chris.horizontalbarsdemo.fragment.CirclesBarsFragment;
import com.chris.horizontalbarsdemo.fragment.FiveColorBarFragment;
import com.chris.horizontalbarsdemo.fragment.ShadingBarFragment;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;

    private RadioButton btn1;

    private RadioButton btn2;

    private RadioButton btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        btn1 = (RadioButton)findViewById(R.id.btn1);
        btn2 = (RadioButton)findViewById(R.id.btn2);
        btn3 = (RadioButton)findViewById(R.id.btn3);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == btn1.getId())
                {
                    getFragmentManager().beginTransaction().replace(R.id.content,new CirclesBarsFragment()).commit();

                }else if(checkedId == btn2.getId())
                {
                    getFragmentManager().beginTransaction().replace(R.id.content,new FiveColorBarFragment()).commit();

                }else
                {
                    getFragmentManager().beginTransaction().replace(R.id.content,new ShadingBarFragment()).commit();

                }
            }
        });


        getFragmentManager().beginTransaction().replace(R.id.content,new CirclesBarsFragment()).commit();
    }
}
