package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Maxim on 20.10.2015.
 */
public class Moon implements Planet
{
    private static Moon earthObj = null;

    private Moon(){}

    public static Moon getInstance()
    {
        if(earthObj == null) earthObj = new Moon();

        return earthObj;
    }
}
