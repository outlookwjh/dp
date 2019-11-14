package com.designpatterns.factorymethod;

public class BananaFactory implements Factory {
    @Override
    public Fruit createFruit() {
        return new Banana();
    }
}
