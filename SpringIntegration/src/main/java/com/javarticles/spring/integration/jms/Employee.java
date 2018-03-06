package com.javarticles.spring.integration.jms;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String toString() {
        return "Employee: [" + name + ", ID: " + id + ", AGE " + age + "]";
    }
}
