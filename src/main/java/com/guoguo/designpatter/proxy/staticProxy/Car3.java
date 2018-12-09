package com.guoguo.designpatter.proxy.staticProxy;

/**
 * 通过聚合来实现方法代理 , 记录汽车行驶的时间
 *
 *  通过构造方法把car传进来
 */
public class Car3 implements Moveable {

    private Car car;

    public Car3(Car car){
        super();
        this.car = car;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();

        this.car.move();

        long endTime = System.currentTimeMillis();
        System.out.println( "汽车行驶的时间:" + (endTime - startTime) + "毫秒");

    }
}
