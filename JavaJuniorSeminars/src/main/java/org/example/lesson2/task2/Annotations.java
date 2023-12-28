package org.example.lesson2.task2;

import java.lang.reflect.Field;

public class Annotations {
    public static void main(String[] args) throws NoSuchFieldException {
        MyClass myClass = new MyClass();
//        System.out.println(myClass.getValue());

//        Field negativeField = MyClass.class.getDeclaredField("negative");
//        RandomInteger annotation = negativeField.getAnnotation(RandomInteger.class);
//        System.out.println(annotation.minValue());
//        System.out.println(annotation.maxValue());

        RandomIntegerProcessor.processObject(myClass);

        System.out.println(myClass.getPositive());
        System.out.println(myClass.getNegative());

    }

    static class MyClass {
        @RandomInteger(minValue = -100, maxValue = -20)
        private int negative;

        @RandomInteger(minValue = 50, maxValue = 200)
        private int positive;

        public int getNegative() {
            return negative;
        }

        public int getPositive() {
            return positive;
        }
    }
}
