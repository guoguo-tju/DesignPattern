package com.guoguo.designpatter.proxy.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 描述:
 * 创建代理类
 *
 * @author guozh
 * @create 2018-12-09 18:40
 */
public class CglibProxy implements MethodInterceptor {

    // 帮助生成代理类
    private Enhancer enhancer = new Enhancer();

    // 一个返回代理类的方法
    public Object getProxy(Class clazz){
        //设置要代理的类
        enhancer.setSuperclass(clazz);
        //一个回调方法
        enhancer.setCallback(this);

        // 生成代理类
        return enhancer.create();
    }

    /**
     *  拦截所有目标类方法的调用
     * @param o     目标类的实例
     * @param method   目标方法的反射对象
     * @param objects  方法的参数
     * @param methodProxy   代理类的实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("开始行驶");
        //代理类调用父类(目标类)的方法
        methodProxy.invokeSuper(o , objects);
        System.out.println("结束行驶");

        return null;
    }
}