package com.guoguo.designpatter.factory;

/**
 * 发型工厂类
 *
 *  根据传入的名称创立相应的子类
 */
public class HairFactory {


    public HairInterface getHair(String key) {

        //这个方法的缺陷是每增加一个类型就得多写一个if-else,太麻烦.使用反射解决.
        if (key.equals("left")){
            return new LeftHair();
        }else if (key.equals("right")){
            return new RightHair();
        }else {
            return null;
        }

    }

    //使用反射,直接传入类名来创建对象
    public HairInterface getHairByClass(String className){
        HairInterface hair = null;
        try {
            hair = (HairInterface) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hair;
    }

}
