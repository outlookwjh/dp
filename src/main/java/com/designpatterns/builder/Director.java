package com.designpatterns.builder;

public class Director {

    public void makeHouse(HouseBuilder houseBuilder){
        houseBuilder.makeFloor();
        houseBuilder.makeHouseTop();
        houseBuilder.makeWall();
    }

}
