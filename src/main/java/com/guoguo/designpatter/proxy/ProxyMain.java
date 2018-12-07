package com.guoguo.designpatter.proxy;

/**
 *  静态代理:代理和被代理对象在代理之前是确定的.他们都实现相同的接口或者继承相同的抽象类.
 *
 *    使用继承的方式实现,代理类会无限膨胀下去,每种功能就要实现一次代理.
      使用聚合的方式实现,只要调整代理的顺序,更加灵活,因为代理之间是会互相传递,互相组合的.推荐
 */
public class ProxyMain {


    public static void main(String[] args) {

        //使用继承方式,重写父类方法
        Car2 car2 = new Car2();
        car2.move();
        System.out.println("================");
        //使用聚合方式,将Car作为一个属性,在构造方法内传入
        Car car = new Car();
        Car3 car3 = new Car3(car);
        car3.move();
        System.out.println("================");
        // 要实现日志功能和记录时间功能的不同组合呢
        // 推荐用聚合方式 , 不同的代理功能之间可以随意调整顺序组合.
        Car car1 = new Car();
        CarTimeProxy carTimeProxy = new CarTimeProxy(car1);
        CarLogProxy carLogProxy = new CarLogProxy(carTimeProxy);
        carLogProxy.move();
        System.out.println("================");
        CarLogProxy carLogProxy1 = new CarLogProxy(car1);
        CarTimeProxy carTimeProxy1 = new CarTimeProxy(carLogProxy1);
        carTimeProxy1.move();
        System.out.println("================");


    }
}
