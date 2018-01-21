package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Maxim on 16.10.2015.
 */
public class RealiseSingleton
{
    private static RealiseSingleton obj = null;
    private RealiseSingleton()
    {

    }

    public static RealiseSingleton getInstance()
    {
        if(obj == null) obj = new RealiseSingleton();

        return obj;
    }
}
