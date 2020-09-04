package com.example.crashdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CrashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
    }

    public void click(View view) throws Exception {
       new Thread(new Runnable() {
           @Override
           public void run() {
               TextView textView = null;
               textView.setText("hell,word");
           }
       }).start();
    }
}
