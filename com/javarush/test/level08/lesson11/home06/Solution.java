package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Human gFather1 = new Human("Vasia", true, 80, new ArrayList<Human>());
        Human gFather2 = new Human("Vasia2", true, 81, new ArrayList<Human>());
        Human gMother1 = new Human("Nadia", false, 78, new ArrayList<Human>());
        Human gMother2 = new Human("Nadia2", false, 79, new ArrayList<Human>());
        Human father = new Human("Vova", true, 48, new ArrayList<Human>());
        Human mother = new Human("Ira", false, 45, new ArrayList<Human>());

        Human maks = new Human("Maks", true, 22, new ArrayList<Human>());
        Human dasha = new Human("Dasha", false, 28, new ArrayList<Human>());
        Human nastia = new Human("Nastia", false, 20, new ArrayList<Human>());


        System.out.println(gFather1);
        System.out.println(gFather2);
        System.out.println(gMother1);
        System.out.println(gMother1);
        System.out.println(gMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(maks);
        System.out.println(dasha);
        System.out.println(nastia);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
