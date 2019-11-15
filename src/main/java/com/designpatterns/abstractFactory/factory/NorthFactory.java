package com.designpatterns.abstractFactory.factory;

import com.designpatterns.abstractFactory.product.Fruit_af;
import com.designpatterns.abstractFactory.product.NorthApple_af;
import com.designpatterns.abstractFactory.product.NorthBanana_af;

public class NorthFactory implements fruitFactory {


    @Override
    public Fruit_af getApple() {
        return new NorthApple_af();
    }

    @Override
    public Fruit_af getBanana() {
        return new NorthBanana_af();
    }
}
