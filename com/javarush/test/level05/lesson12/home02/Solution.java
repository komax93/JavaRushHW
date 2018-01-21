package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Maxim", 22, "Lomonosova, 7");
        Man man2 = new Man("Ilo", 50, "Lomonosova, 7");

        Woman woman1 = new Woman("Ira", 45, "Lomonosova, 7");
        Woman woman2 = new Woman("Natia", 20, "Lomonosova, 7");

        man1.getInfo();
        man2.getInfo();

        woman1.getInfo();
        woman2.getInfo();
    }

    public static class Man
    {
        private String name, address;
        private int age;

        public Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public void getInfo()
        {
            System.out.println("[" + this.name + " " + this.age + " " + this.address + "]");
        }
    }

    public static class Woman
    {
        private String name, address;
        private int age;

        public Woman(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public void getInfo()
        {
            System.out.println("[" + this.name + " " + this.age + " " + this.address + "]");
        }
    }
}
