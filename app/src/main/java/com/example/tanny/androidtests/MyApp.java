package com.example.tanny.androidtests;

import android.app.Application;

/**
 * Created by Tanny on 30/06/2014.
 */
public class MyApp extends Application {
    public static final String  buildType = "test";

    public MyApp() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
