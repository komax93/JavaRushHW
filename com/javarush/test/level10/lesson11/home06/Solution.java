package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name;
        private int age;
        private boolean sex;
        private double height;
        private String color;
        private String surname;

        public Human(){}

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, double height)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
        }

        public Human(String name, int age, boolean sex, double height, String color)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.color = color;
        }

        public Human(String name, int age, boolean sex, double height, String color, String surname)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.color = color;
            this.surname = surname;
        }

        public Human(String name, String surname)
        {
            this.name = name;
            this.surname = surname;
        }

        public Human(String surname, double height)
        {
            this.surname = surname;
            this.height = height;
        }

        public Human(String name, boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }

    }
}
