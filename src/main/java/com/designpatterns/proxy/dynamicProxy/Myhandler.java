package com.designpatterns.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Myhandler implements InvocationHandler {



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        driveTime();
        Object result = method.invoke(Car.class.newInstance(), args);
        return result;
    }

    void driveTime(){
        System.out.println("on the night,");
    }
}
