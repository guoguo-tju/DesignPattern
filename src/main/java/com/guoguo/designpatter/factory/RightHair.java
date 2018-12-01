package com.guoguo.designpatter.factory;

public class RightHair implements HairInterface {
    @Override
    public void getHair() {
        System.out.println("实现右偏分的发型");
    }
}
