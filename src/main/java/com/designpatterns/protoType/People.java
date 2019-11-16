package com.designpatterns.protoType;

import java.util.List;

/**
 * 原型模式之浅克隆，浅克隆不能克隆引用类型
 */
public class People implements Cloneable{

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

    public People clone(){

        try {
            return (People) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

