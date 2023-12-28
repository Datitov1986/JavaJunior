package org.example.lesson2.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);

        constructor.setAccessible(true);
        Person person = constructor.newInstance("Igor");
        System.out.println(person);

        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(person, 160);
        System.out.println(person);

        Field nameField = personClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(person, "igor - 2");
        System.out.println(person);

        Method toStringMethod = personClass.getMethod("toString");
        Object toStringResult = toStringMethod.invoke(person);
        System.out.println(toStringResult);

        Person person1 = Person.randomPerson();
        System.out.println(person1);

        Method randomPersonMethod = personClass.getMethod("randomPerson");
        Object randomPerson = randomPersonMethod.invoke(null);
        System.out.println(randomPerson);
    }


}
