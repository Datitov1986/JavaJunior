package org.example.homework1.task1;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1000000))
                .limit(1000)
                .collect(Collectors.toList()); //Создание листа из 1000 чисел

        //Поиск максимального числа из списка
        int maxValue = list.stream().max(Math::max).get();
        System.out.println(maxValue);

        //находит все числа больше 50000, умножает на 5, вычитает 150 и суммирует их.
        long sum = list.stream()
                .filter(num -> num > 50000)
                .mapToLong(num -> (num * 5) - 150)
                .sum();
        System.out.println(sum);

        //находит количество чисел, квадрат которых меньше, чем 100.
        long count = list.stream().filter(num -> (num * num) < 100000).count();
        System.out.println(count);
    }
}
