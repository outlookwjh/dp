package com.designpatterns.factorymethod;

public class peerFactory implements Factory {
    @Override
    public Fruit createFruit() {
        return new Peer();
    }
}
