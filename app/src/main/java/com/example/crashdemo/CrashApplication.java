package com.example.crashdemo;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class CrashApplication extends Application {

    public static CrashApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //   Thread.currentThread().setUncaughtExceptionHandler(new CrashHandler());
        Handler handler = new Handler(getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Looper.loop();
                    } catch (Exception e) {
                        Toast.makeText(instance, "抛出了异常", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler());
    }
}
