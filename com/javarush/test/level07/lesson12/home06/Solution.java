package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human grandPa1 = new Human("дед Василий", true, 80);
        Human grandPa2 = new Human("дед Сергей", true, 75);

        Human grandMa1 = new Human("баба Анька", false, 73);
        Human grandMa2 = new Human("баба Настя", false, 64);

        Human father = new Human("папа Вова", true, 40, grandPa1, grandMa1);
        Human mother = new Human("мама Ира", false, 35, grandPa2, grandMa2);

        Human daughter = new Human("Дина", false, 20, father, mother);
        Human oldSon = new Human("Дима", true, 15, father, mother);
        Human juniorSon = new Human("Денис", true, 10, father, mother);

        System.out.println(grandPa1);
        System.out.println(grandPa2);
        System.out.println(grandMa1);
        System.out.println(grandMa2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(daughter);
        System.out.println(oldSon);
        System.out.println(juniorSon);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = null;
            this.mother = null;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = new Human(father.name, father.sex, father.age);
            this.mother = new Human(mother.name, mother.sex, mother.age);
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
