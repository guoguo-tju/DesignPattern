package com.guoguo.designpatter.proxy.cglibProxy;

/**
 * 描述:
 *
 * @author guozh
 * @create 2018-12-09 18:54
 */
public class CglibTest {

    public static void main(String[] args) {

        CglibProxy cglibProxy = new CglibProxy();
        Train t = (Train) cglibProxy.getProxy(Train.class);
        t.move();

    }
}