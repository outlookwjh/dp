package com.designpatterns.decorator;

/**
 * 具体的装饰着
 */
public class SwimDecorator extends Decorator{
    public SwimDecorator(CarAction car) {
        super(car);
    }

    @Override
    public void show() {
        super.car.show();
        swim();
    }

     public void swim(){
        System.out.println("会游泳的车");
    }
}
