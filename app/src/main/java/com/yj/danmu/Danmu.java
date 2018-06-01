package com.yj.danmu;

public class Danmu {
    // 内容
    private String text;
    // 速度
    private int speed;
    // 延迟多少ms出现
    private int delay;
    // x坐标
    private int x;
    // y坐标
    private int y = -1;

    public Danmu(String text, int speed, int x) {
        this.text = text;
        this.speed = speed;
        this.x = x;
    }

    public void update() {
        x = x - speed;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
