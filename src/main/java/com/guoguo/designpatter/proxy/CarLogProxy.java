package com.guoguo.designpatter.proxy;

public class CarLogProxy implements Moveable {

    //用接口代替具体的实现类
    private Moveable m;

    public CarLogProxy(Moveable m){
        super();
        this.m = m;
    }


    @Override
    public void move() {
        System.out.println("开始打印log");

        this.m.move();

        System.out.println("结束打印log");
    }
}
