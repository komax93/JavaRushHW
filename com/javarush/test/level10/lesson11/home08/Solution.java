package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
import java.util.*;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] list = new ArrayList[2];

        ArrayList<String> l1 = new ArrayList<String>();
        l1.add("First");
        l1.add("Second");
        l1.add("Third");

        ArrayList<String> l2 = new ArrayList<String>();
        l2.add("komax93");
        l2.add("dimitriym");
        l2.add("dzhurao");

        list[0] = l1;
        list[1] = l2;


        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}