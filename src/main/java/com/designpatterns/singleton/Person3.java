package com.designpatterns.singleton;

/**
 * 单例模式： 懒汉式,双重检查，适合多线程；
 */
public class Person3 {


    private static Person3 per1 ;

    public static Person3 getInstance(){
       if (per1 == null){
           synchronized (Person3.class){
               if (per1 == null){
                   per1 = new Person3();
               }
           }

       }
       return per1;
    }

    public Person3() {
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
