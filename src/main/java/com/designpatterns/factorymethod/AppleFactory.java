package com.designpatterns.factorymethod;

public class AppleFactory implements Factory {
    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}
