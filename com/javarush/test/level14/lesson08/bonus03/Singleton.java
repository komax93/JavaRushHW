package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Maxim on 16.10.2015.
 */
public class Singleton
{
    private static Singleton obj = null;
    private Singleton()
    {

    }

    public static Singleton getInstance()
    {
        if(obj == null) obj = new Singleton();
        return obj;
    }
}
