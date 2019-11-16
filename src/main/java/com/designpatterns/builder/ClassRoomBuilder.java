package com.designpatterns.builder;

/**
 * 修建教室的施工队
 */
public class ClassRoomBuilder implements HouseBuilder {

    House classroom = new House();

    @Override
    public House buildHouse() {
        return classroom;
    }

    @Override
    public void makeWall() {
         classroom.setFloor("教室--》墙");
    }

    @Override
    public void makeHouseTop() {
        classroom.setHouseTop("教室--》屋顶");
    }

    @Override
    public void makeFloor() {
        classroom.setFloor("教室--》地板");
    }
}
