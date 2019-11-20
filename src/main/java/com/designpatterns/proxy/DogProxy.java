package com.designpatterns.proxy;

/**
 * 代理对象
 */
public class DogProxy implements DogInerface{

    Dog dog;

    public DogProxy(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void speak() {
        action();
        dog.speak();
    }

    public void action(){

        System.out.println("stand on desk");
    }

}
