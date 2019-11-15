package com.designpatterns.abstractFactory.factory;

import com.designpatterns.abstractFactory.product.*;

public class SourthFactory implements fruitFactory {


    @Override
    public Fruit_af getApple() {
        return new SourthApple_af();
    }

    @Override
    public Fruit_af getBanana() {
        return new SourthBanana_af();
    }
}
