package com.example.kotlindemo04.EventbusDemo;

public class EvetbusBean {

    private String name;

    private int age;

    public EvetbusBean(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "EvetbusBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
