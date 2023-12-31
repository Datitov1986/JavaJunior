package org.example.lesson2.task1;

public class Person {
    private static long counter = 1L;
    private final String name;
    private int age;

    private Person (String name) {
        this(name,20);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Person randomPerson() {
        return new Person("Person #" + counter++);
    }

    @Override
    public String toString() {
        return String.format("%s - [%s]", name,age);
    }
}
