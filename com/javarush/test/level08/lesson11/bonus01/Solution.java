package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        LinkedList<String> listMonth = new LinkedList<String>();
        listMonth.add("January");
        listMonth.add("February");
        listMonth.add("March");
        listMonth.add("April");
        listMonth.add("May");
        listMonth.add("June");
        listMonth.add("July");
        listMonth.add("August");
        listMonth.add("September");
        listMonth.add("October");
        listMonth.add("November");
        listMonth.add("December");

        for(int i = 0; i < listMonth.size(); i++)
            if(listMonth.get(i).equals(month))
            {
                System.out.println(month + " is " + (i + 1) + " month");
                break;
            }
    }

}
