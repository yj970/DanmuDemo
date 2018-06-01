package com.yj.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DanmuView extends View {

    // 弹幕池
    List<Danmu> danmuList = new ArrayList<>();
    // 存储池
    List<Danmu> storgeDanmuList = new ArrayList<>();

    // 一屏只能有多少条弹幕
    int maxDanmuSize = 20;

    // 多少行弹幕
    int line = 10;

    // 画笔
    Paint paint;

    // 设备width
    int width;

    // 设备height
    int height;

    // 历史弹幕出现的顺序
    int pos;

    // 弹幕之间的距离
    int offset;


    public DanmuView(@NonNull Context context) {
        super(context);
        init();
    }

    public DanmuView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DanmuView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setTextSize(30);

        width = getResources().getDisplayMetrics().widthPixels;
        height = getResources().getDisplayMetrics().heightPixels;
        offset = height/line - 10;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
            for (int i = 0; i < danmuList.size() ; i++){
                Danmu danmu = danmuList.get(i);
                canvas.drawText(danmu.getText(), danmu.getX(), danmu.getY(), paint);
                danmu.update();
        }
    }

    public void addDanmu(Danmu danmu) {
        storgeDanmuList.add(danmu);
    }

    public void start() {
        // 弹幕增加timer
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // 弹幕池要移除
                for (int i = 0; i < danmuList.size(); i++) {
                    Danmu danmu = danmuList.get(i);
                    if (danmu.getX()<0) {
                        danmuList.remove(danmu);
                    }
                }

                // 弹幕池要增加
                if (danmuList.size() <= maxDanmuSize) {
                    Danmu danmu = storgeDanmuList.get(0);
                    danmu.setY((int) (pos %line*offset+(paint.getFontMetrics().bottom-paint.getFontMetrics().top)));
                    danmuList.add(danmu);
                    pos++;
                    storgeDanmuList.remove(0);
                }
            }
        }, 0, 1000);

        // 刷新timer
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                postInvalidate();
            }
        }, 0, 150);
    }

}
