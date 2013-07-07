package ru.bogdanov_android_test;

import java.io.*;

public class Main {
    public static void main (String Args[]) throws IOException {
        //создаем объект
        Person shalyapin = new Person("Seva", "Shalyapin", 12, false);
        load(shalyapin);
    }

    static void load(Person person) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }
}
