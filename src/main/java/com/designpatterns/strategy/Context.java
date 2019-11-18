package com.designpatterns.strategy;

import java.util.HashMap;
import java.util.Map;

public  class Context {

    static Map<String,Object> map = new HashMap<>();

    static {
        try {
            map.put("1",Class.forName("com.designpatterns.strategy.StrategyA").newInstance());
            map.put("2",Class.forName("com.designpatterns.strategy.StrategyB").newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("初始化类错误");
        }
    }

    public strategy getStrategy(String code){
        return (strategy) map.get(code);
    }

}
