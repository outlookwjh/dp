package com.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
public class StudentClass implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("学生们可以放学了");
    }
}
