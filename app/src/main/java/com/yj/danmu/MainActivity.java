package com.yj.danmu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    DanmuView danmu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        danmu = findViewById(R.id.v);
        for (int i = 0; i < 500; i++) {
            danmu.addDanmu(DanmuFactory.getDefaultDanmu(this, "弹幕测试 " + i));
        }
        danmu.start();
    }
}
