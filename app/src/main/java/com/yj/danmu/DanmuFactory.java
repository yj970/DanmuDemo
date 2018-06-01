package com.yj.danmu;

import android.content.Context;

import java.util.Random;


public class DanmuFactory {

    public static Danmu getDefaultDanmu(Context context, String text) {
        int speed = new Random().nextInt(20)+10;
        return new Danmu(text, speed, context.getResources().getDisplayMetrics().widthPixels);
    }
}
