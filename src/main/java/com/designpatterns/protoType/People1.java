package com.designpatterns.protoType;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式之深克隆，克隆引用类型
 */
public class People1 implements Cloneable{

    private String name;

    private int age;

    private String sex;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", pets=" + pets +
                '}';
    }

    List<String> pets;

    public List<String> getPets() {
        return pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public People1 clone(){

        try {
            People1 people1 = new People1();
            people1 = (People1)super.clone();
            List pet1 = new ArrayList<>();
            for (String pet : this.pets) {
                pet1.add(pet);
            }
            people1.setPets(pet1);
            return people1;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

