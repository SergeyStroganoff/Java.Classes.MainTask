package com.stroganov;
/*

Main Task
Для выполнения достаточно выбрать одно задание.
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов.
Задать критерий выбора данных и вывести эти данные на консоль.
В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.

Создать массив объектов. Вывести:

a) список студентов заданного факультета;
b) списки студентов для каждого факультета и курса;
c) список студентов, родившихся после заданного года;
d) список учебной группы.

 */

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> studentArrayList = new ArrayList<>();

        studentArrayList.add(new Student(1, "Строганов", "Сергей", "Михайлович", "28.12.1980", "Тверь, ул. Можайского, дом 277, кв. 8", "89159201234", "Лингвистика", 1, "1B"));
        studentArrayList.add(new Student(2, "Иванов", "Сергей", "Семенович", "24.10.1982", "Тверь, ул. Хромова, дом 7, кв. 89", "Математика", 3, "2Д"));
        studentArrayList.add(new Student(3, "Аракчеев", "Павел", "Борисович", "20.01.1985", "Тверь, ул. Б.Зуевская, дом 12", "Философия", 4, "1Г"));


        // выводим список студентов факультета "Математика".

        for (Student student : studentArrayList
        ) {
            if (student.getFacultet().equals("Математика")) {
                System.out.println(student.toString());
            }
        }
        // списки студентов для каждого факультета и курса"


        System.out.println("b) списки студентов для каждого факультета и курса");

        ArrayList<String> facultet = new ArrayList<>();

        for (Student student : studentArrayList) {
            facultet.add(student.getFacultet());
        }

        for (String currentFacultet : facultet) {

            System.out.println("Список студентов факультета: " + currentFacultet + " :");

            printSelectedStudent(studentArrayList, "Факультет", currentFacultet);
        }

        // для каждого курса

        ArrayList<Integer> course = new ArrayList<>();

        for (Student student : studentArrayList) {
            course.add(student.getCourse());
        }

        for (Integer currentCourse : course) {

            System.out.println("Список студентов курса: " + currentCourse + ":");

            printSelectedStudent(studentArrayList, "Курс", currentCourse);
        }

        // список студентов каждой группы

        ArrayList<String> group = new ArrayList<>();

        for (Student student : studentArrayList) {
            group.add(student.getGroup());
        }

        for (String currentGroup : group) {

            System.out.println("Список студентов группы: " + currentGroup + ":");

            printSelectedStudent(studentArrayList, "Группа", currentGroup);
        }

        // c) список студентов, родившихся после заданного года - 1980;

        System.out.println("Список студентов родившихся после 1980 года");

        ArrayList<Student> studentsYears = new ArrayList<>();

        for (Student student : studentArrayList) {

            LocalDate bithday = student.getBirthday();
            int yearBithday = bithday.getYear();

            if (yearBithday > 1980) {
                studentsYears.add(student);
            }
        }

        for (Student currentstudent : studentsYears) {

            System.out.println(currentstudent.toString());
        }
    }

    public static <T> void printSelectedStudent(ArrayList<Student> student, String parametr, T value) {
        T currentValue;

        for (Student currentStudent : student) {

            switch (parametr) {
                case "Факультет":
                    currentValue = (T) currentStudent.getFacultet();
                    break;
                case "Курс":
                    currentValue = (T) currentStudent.getCourse();
                    break;
                case "Группа":
                    currentValue = (T) currentStudent.getGroup();
                    break;


                default:
                    throw new IllegalArgumentException();
            }

            if (currentValue.equals(value)) {
                System.out.println(currentStudent.toString());
            }
        }
    }
}


