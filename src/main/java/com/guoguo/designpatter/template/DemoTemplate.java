package com.guoguo.designpatter.template;

import jdk.nashorn.internal.ir.IfNode;

/**
 * @program: DesignPattern
 * @description: 模板基类(抽象)
 * @author: Karl Guo
 * @create: 2018-12-14 11:15
 **/
public abstract class DemoTemplate {


    /**
     *  模板方法,封装了子类共同遵循的算法框架,final修饰方法,使得不能被子类复写修改
     */
    protected final void demoStepTemplate(){

        // 通用的无差别的方法 , private修饰,向下屏蔽实现细节
        step1();

        // 通过一个Hook函数让子类来选择是否执行step2 , 给子类更大的灵活性
        if (isWantStep2()){

            // 需子类复写的方法 , protected修饰
            step2();
        }



    }



    private void step1(){
        System.out.println("step1执行了");
    };


    // 抽象方法,让子类来实现
    protected abstract void step2();


    /**
     * 钩子函数,提供一个默认或者null的实现
     * 		    具体的子类可以自行决定是否挂钩以及如何挂钩(通过重写钩子方法)
     * @return
     */
    protected  boolean isWantStep2(){
        return true;
    };


}
