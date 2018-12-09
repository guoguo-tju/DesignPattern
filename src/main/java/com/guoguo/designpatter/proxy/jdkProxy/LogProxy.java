package com.guoguo.designpatter.proxy.jdkProxy;

import com.guoguo.designpatter.proxy.staticProxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述:
 * 日志的代理处理
 *
 * @author guozh
 * @create 2018-12-09 17:37
 */
public class LogProxy implements InvocationHandler  {

    private Object target;

    public LogProxy(Object m ){
        super();
        this.target = m;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("开始打印log");


        method.invoke(this.target);
        System.out.println("结束打印log");


        return null;
    }
}