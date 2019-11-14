package com.designpatterns.simplefactory;

/**
 * 简单工厂类
 */
public class Factory {

    public static Fruit getinstance(String type) throws Exception {

        /**
         * 创建对象的第一种写法
         */
        if (type.equalsIgnoreCase("apple")){
            return Apple.class.newInstance();
        }else if (type.equalsIgnoreCase("banana")){
            return Banana.class.newInstance();
        }

        /**
         * 创建对象的第二种写法，简洁，灵活性不高
         */
        Class name = Class.forName(type);

        Fruit fruit = (Fruit) name.newInstance();

        return fruit;

    }
}
