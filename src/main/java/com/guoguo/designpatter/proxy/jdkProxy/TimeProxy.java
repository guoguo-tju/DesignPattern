package com.guoguo.designpatter.proxy.jdkProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述:
 * 时间的代理实现
 *
 * @author guozh
 * @create 2018-12-09 17:03
 */
public class TimeProxy implements InvocationHandler {

    // 通过构造将被代理对象传入
    private Object target;

    public TimeProxy(Object target){
        super();
        this.target = target;
    }


    /**
     *
     * @param proxy  被代理类对象
     * @param method    被代理的方法
     * @param args      方法的参数
     * @return Object 调用方法之后的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long startTime = System.currentTimeMillis();
        System.out.println("开始计时");

        method.invoke(target);

        long endTime = System.currentTimeMillis();
        System.out.println("结束计时");
        System.out.println( "汽车行驶的时间:" + (endTime - startTime) + "毫秒");

        return null;
    }
}