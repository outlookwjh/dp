package com.designpatterns.singleton;

/**
 * 单例模式： 饿汉式，一开始就初始化对象，且是静态的，线程安全；
 */
public class Person1 {


    private static final Person1 per1 = new Person1();

    public static Person1 getInstance(){
        return per1;
    }

    public Person1() {
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
