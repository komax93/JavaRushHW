package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        HashMap<String, Cat> map = new HashMap<String, Cat>();
        map.put("Sonja1", new Cat("Sonja1"));
        map.put("Sonja2", new Cat("Sonja2"));
        map.put("Sonja3", new Cat("Sonja3"));
        map.put("Sonja4", new Cat("Sonja4"));
        map.put("Sonja5", new Cat("Sonja5"));
        map.put("Sonja6", new Cat("Sonja6"));
        map.put("Sonja7", new Cat("Sonja7"));
        map.put("Sonja8", new Cat("Sonja8"));
        map.put("Sonja9", new Cat("Sonja9"));
        map.put("Sonja10", new Cat("Sonja10"));


        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        HashSet<Cat> set = new HashSet<Cat>();
        Iterator<Map.Entry<String, Cat>> iterator = map.entrySet().iterator();

        while(iterator.hasNext())
        {
            Map.Entry<String, Cat> pair = iterator.next();
            Cat name = pair.getValue();
            set.add(name);
        }

        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
