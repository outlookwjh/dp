package com.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class TeacherClass implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("老师们可以下班了");
    }
}
