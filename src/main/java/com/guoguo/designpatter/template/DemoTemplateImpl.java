package com.guoguo.designpatter.template;

/**
 * @program: DesignPattern
 * @description: 基类的实现类
 * @author: Karl Guo
 * @create: 2018-12-14 12:02
 **/
public class DemoTemplateImpl extends DemoTemplate {


    @Override
    protected void step2() {
        System.out.println("step2执行了");
    }

    /**
     * 子类通过重写的形式选择挂钩函数,自己选择是否执行step2
     * @return
     */
    @Override
    protected  boolean isWantStep2(){
        return false;
    }
}
