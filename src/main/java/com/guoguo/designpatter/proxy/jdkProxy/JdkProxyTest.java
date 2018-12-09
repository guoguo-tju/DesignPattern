package com.guoguo.designpatter.proxy.jdkProxy;

import com.guoguo.designpatter.proxy.staticProxy.Car;
import com.guoguo.designpatter.proxy.staticProxy.Moveable;

import java.lang.reflect.Proxy;

/**
 * 描述:
 *
 * @author guozh
 * @create 2018-12-09 17:28
 */
public class JdkProxyTest {


    public static void main(String[] args) {
        Car car = new Car();
        Class<?> carCls = car.getClass();
        // 实现时间代理
        TimeProxy timeProxy = new TimeProxy(car);

        /**
         *  loader 类加载器
         *  interfaces 实现接口
         *  InvocationHandler
         */
        // 用Moveable接口接受代理类
        Moveable m = (Moveable) Proxy.newProxyInstance(carCls.getClassLoader(), carCls.getInterfaces(),timeProxy);
//        m.move();
        // 实现日志代理和时间代理 ， 日志代理在外，时间代理在内。
        LogProxy logProxy = new LogProxy(m);
        Moveable m2 = (Moveable) Proxy.newProxyInstance(carCls.getClassLoader(), carCls.getInterfaces(), logProxy);
        m2.move();
    }
}