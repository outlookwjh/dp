package com.designpatterns.factorymethod;

public class Peer implements Fruit {
    @Override
    public void get() {
        System.out.println("PEER");
    }
}
