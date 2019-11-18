package com.designpatterns.strategy;

public class StrategyA implements strategy {
    @Override
    public void print(String code) {
        if ("1".equalsIgnoreCase(code)){
            System.out.println("我爱java");
        }
    }
}
