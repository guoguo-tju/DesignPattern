package com.guoguo.designpatter.proxy.staticProxy;

import java.util.Random;

public class Car implements Moveable {

    @Override
    public void move() {
        try {

            System.out.println("汽车开始行驶");
            Thread.sleep(new Random().nextInt(1000));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
