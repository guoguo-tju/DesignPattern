package com.guoguo.designpatter.factory;

public class Test01 {


    public static void main(String[] args) {

        // 1.创建工厂类的实例,通过工厂类实例指定对象名来创建对象
        HairFactory hairFactory = new HairFactory();
        HairInterface left = hairFactory.getHair("left");
        left.getHair();


        // 2.通过反射,传入类全名来创建对象.
        // 如果觉得传全路径麻烦,可以写一个配置文件的映射,比如right=com.guoguo.designpatter.factory.RightHair
        HairFactory hairFactory1 = new HairFactory();
        HairInterface right = hairFactory1.getHairByClass("com.guoguo.designpatter.factory.RightHair");
        right.getHair();


    }
}
