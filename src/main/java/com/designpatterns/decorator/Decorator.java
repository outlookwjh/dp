package com.designpatterns.decorator;

/**
 * 装饰者抽象类,持有被装饰者对象
 */
public abstract class Decorator implements CarAction{


    CarAction car;

    public Decorator(CarAction car) {
        this.car = car;
    }

    public abstract void show();
}
