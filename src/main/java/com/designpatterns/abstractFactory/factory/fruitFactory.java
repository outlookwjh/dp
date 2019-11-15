package com.designpatterns.abstractFactory.factory;

import com.designpatterns.abstractFactory.product.Fruit_af;

/**
 * 抽象工厂接口，这个接口是对外暴露的
 */
public interface fruitFactory {
    public Fruit_af getApple();
    public Fruit_af getBanana();
}
