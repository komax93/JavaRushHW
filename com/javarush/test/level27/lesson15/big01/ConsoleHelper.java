package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Maxim on 05.03.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        String str = reader.readLine();

        return str;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> list = new ArrayList<Dish>();
        String select;
        writeMessage("Please choose your dish " + Dish.allDishesToString() + ":");
        while(true)
        {
            select = readString();
            if (select.equals("exit"))
                break;

            try
            {
                list.add(Dish.valueOf(select));
            }
            catch (IllegalArgumentException e)
            {
                ConsoleHelper.writeMessage(select + " is not detected");
            }
        }

        return list;
    }
}
