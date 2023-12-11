package org.example.lesson2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class);

        Person person = constructor.newInstance("Igor");
        System.out.println(person);

    }

    static class Person {
        private final String name;
        private int age;

        public Person (String name) {
            this(name,20);
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s - [%s]", name,age);
        }
    }
}
