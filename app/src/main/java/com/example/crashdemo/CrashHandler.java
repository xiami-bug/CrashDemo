package com.example.crashdemo;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;


public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull final Throwable throwable) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(CrashApplication.instance,"UncaughtException："+throwable.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
