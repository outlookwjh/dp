package com.designpatterns.proxy;

/**
 * 被代理对象
 */
public class Dog implements DogInerface{
    @Override
    public void speak() {
        System.err.println("Dog speak chinese");
    }
}
