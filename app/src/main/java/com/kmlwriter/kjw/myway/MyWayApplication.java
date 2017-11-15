package com.kmlwriter.kjw.myway;

import android.app.Application;
import android.content.Context;

/**
 * Created by kjw on 2017. 11. 15..
 */

public class MyWayApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
    public static Context getContext() {
        return mContext;
    }
}
