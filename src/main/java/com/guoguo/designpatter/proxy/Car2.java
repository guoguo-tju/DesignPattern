package com.guoguo.designpatter.proxy;

/**
 *  通过继承Car重写的父类方法实现代理
 *  通过代理记录汽车行驶的时间
 */
public class Car2 extends Car {

    @Override
    public void move() {

        long startTime = System.currentTimeMillis();

        super.move();

        long endTime = System.currentTimeMillis();
        System.out.println( "汽车行驶的时间:" + (endTime - startTime) + "毫秒");
    }
}
