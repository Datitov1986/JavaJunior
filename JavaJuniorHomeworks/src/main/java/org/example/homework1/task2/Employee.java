package org.example.homework1.task2;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    String name;
    int age;
    double salary;
    String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("Имя сотрудника: %s\n " +
                "возраст сотрудника: %d\n " +
                "зарплата сотрудника: %f\n " +
                "отдел сотрудника: %s\n", name, age, salary, department);
    }

    public static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();

        Employee em1 = new Employee("Евгений Петрович", 57, 58000.56,"Отдел продаж");
        Employee em2 = new Employee("Евгения Михайловна", 22, 580000.78,"Секретариат");
        Employee em3 = new Employee("Илья Максимович", 20, 18000.5,"Отдел продаж");
        Employee em4 = new Employee("Юлия Александровна", 37, 48000.56,"Отдел кадров");
        Employee em5 = new Employee("Инга Валерьевна", 28, 65000.56,"Отдел связей с общественностью");
        Employee em6 = new Employee("Максим Олегович", 17, 8000.56,"Практикант");
        Employee em7 = new Employee("Олег Петрович", 21, 6000.01,"Отдел клининга");
        Employee em8 = new Employee("Дмитрий Иванович", 47, 98000.56,"Отдел кадров");
        Employee em9 = new Employee("Александр Сергеевич", 38, 58000.56,"Отдел маркетинга");
        Employee em10 = new Employee("Петр Валерьянович", 62, 78000.56,"Отдел маркетинга");
        Employee em11 = new Employee("Игнат Ефграфович", 57, 28000.16,"Отдел воинского учета");
        Employee em12 = new Employee("Ольга Васильевна", 55, 98000.16,"Секретариат");
        Employee em13 = new Employee("Чолпонбай Урун Оглы", 54, 3000.5,"Отдел клининга");
        Employee em14 = new Employee("Сашка", 16, 5000.56,"Практикант");
        Employee em15 = new Employee("Залугбек", 35, 6000.56,"Отдел клининга");
        Employee em16 = new Employee("Василий Анатольевич", 46, 58000.56,"Отдел продаж");
        Employee em17 = new Employee("Анатолий Львович", 41, 38000.56,"Производственный отдел");
        Employee em18 = new Employee("Ильдар Архипович", 42, 78000.56,"Отдел продаж");
        Employee em19 = new Employee("Руслан Николаевич", 39, 58000.56,"Производственный отдел");
        Employee em20 = new Employee("Евгений Михайлович", 51, 69000.56,"Производственный отдел");
        employees.add(em1);
        employees.add(em2);
        employees.add(em3);
        employees.add(em4);
        employees.add(em5);
        employees.add(em6);
        employees.add(em7);
        employees.add(em8);
        employees.add(em9);
        employees.add(em10);
        employees.add(em11);
        employees.add(em12);
        employees.add(em13);
        employees.add(em14);
        employees.add(em15);
        employees.add(em16);
        employees.add(em17);
        employees.add(em18);
        employees.add(em19);
        employees.add(em20);
        return employees;
    }
}
