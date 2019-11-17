package com.designpatterns.decorator;

/**
 * 被装饰者
 */
public class RunCar implements CarAction {
    @Override
    public void show() {
        run();
    }

    public void run(){

        System.out.println("会跑的车");
    }


}
