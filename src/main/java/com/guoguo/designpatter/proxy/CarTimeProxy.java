package com.guoguo.designpatter.proxy;

public class CarTimeProxy implements Moveable {

    //用接口代替具体的实现类
    private Moveable m;

    public CarTimeProxy(Moveable m) {
        super();
        this.m = m;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("开始计时");

        this.m.move();

        long endTime = System.currentTimeMillis();
        System.out.println("结束计时");
        System.out.println( "汽车行驶的时间:" + (endTime - startTime) + "毫秒");
    }
}
