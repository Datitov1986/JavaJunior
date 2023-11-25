package org.example.homework1.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Employee.createEmployees();  // Создание списка персонала

        // Вывод списка всех отделов по списку сотрудников
        Set<String> departments = employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        System.out.println("Отделы нашей организации: " + departments);

        // Повышение зарплаты всем сотрудникам, чья зарплата меньше 10000 на 20%
        employees.stream().filter(e -> e.getSalary() < 10000).forEach(e -> e.setSalary(e.getSalary() * 1.20));
        //System.out.println(employees.toString());

        // Из списка сотрудников с помощью стрима создать Map<String, List> с отделами и сотрудниками внутри отдела
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment));
        //System.out.println(employeesByDepartment);

        //Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
        Map<String, Double> averageSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageSalary);
    }
}
