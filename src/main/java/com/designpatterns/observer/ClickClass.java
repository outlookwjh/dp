package com.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者
 */
public class ClickClass extends Observable {

    private String dinglingling;

    public String getDinglingling() {
        return dinglingling;
    }

    public void setDinglingling(String dinglingling) {
        this.dinglingling = dinglingling;
        this.setChanged();
        this.notifyObservers();
    }
}
