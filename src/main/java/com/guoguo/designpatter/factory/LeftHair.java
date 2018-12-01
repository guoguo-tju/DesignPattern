package com.guoguo.designpatter.factory;

public class LeftHair implements HairInterface {
    @Override
    public void getHair() {
        System.out.println("实现左偏分的发型");
    }
}
