package com.designpatterns.singleton;

/**
 * 单例模式： 懒汉式，一开始不初始化对象，第一次进来时初始化对象，线程不安全，不适合多线程操作；
 */
public class Person2 {


    private static   Person2 per1 ;

    public static Person2 getInstance(){
       if (per1 == null){
            per1 = new Person2();
       }
       return per1;
    }

    public Person2() {
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
