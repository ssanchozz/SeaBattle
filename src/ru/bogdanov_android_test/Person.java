package ru.bogdanov_android_test;

import java.io.Serializable;

public class Person implements Serializable {
    private String name, surname;
    private int age;
    private boolean male;

    public Person() {}

    public Person(String name, String surname, int age, boolean male) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return male;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
}


