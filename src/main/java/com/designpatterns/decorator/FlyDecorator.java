package com.designpatterns.decorator;

/**
 * 具体的装饰着
 */
public class FlyDecorator extends Decorator{
    public FlyDecorator(CarAction car) {
        super(car);
    }

    @Override
    public void show() {
        super.car.show();
        fly();
    }

     public void fly(){
        System.out.println("会飞的车");
    }
}
