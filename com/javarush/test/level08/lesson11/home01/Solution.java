package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        Iterator<Cat> iter = cats.iterator();
        while(iter.hasNext())
        {
            Cat cat = iter.next();
            iter.remove();
            break;
        }

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> set = new HashSet<Cat>();
        set.add(new Cat());
        set.add(new Cat());
        set.add(new Cat());

        return set;
    }

    public static void printCats(Set<Cat> cats)
    {
        Iterator<Cat> iter = cats.iterator();
        while(iter.hasNext())
        {
            Cat cat = iter.next();
            System.out.println(cat);
        }
    }

    public static class Cat{
        public Cat(){}
    }
}
