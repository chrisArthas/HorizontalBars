package com.chris.horizontalbarsdemo;

import android.app.Activity;
import android.app.Application;

/**
 * Created by win on 2017/8/18.
 */

public class App extends Application
{
    private static App instance;

    private Activity mainActivity;

    @Override
    public void onCreate()
    {
        super.onCreate();

    }

    public static App getContext()
    {

        return instance;
    }

    public App()
    {

        instance = this;
    }



}
