package com.ligq.utils;

import android.app.Application;
import android.content.Context;

/**
 * @author young
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        GreenDaoHelper.initDatabase();
    }
}
