package com.designpatterns.strategy;

public class StrategyB implements strategy {
    @Override
    public void print(String code) {
        if ("2".equalsIgnoreCase(code)){
            System.out.println("我爱pathon");
        }
    }
}
