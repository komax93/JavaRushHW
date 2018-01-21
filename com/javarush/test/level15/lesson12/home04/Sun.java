package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Maxim on 20.10.2015.
 */
public class Sun implements Planet
{
    private static Sun earthObj = null;

    private Sun(){}

    public static Sun getInstance()
    {
        if(earthObj == null) earthObj = new Sun();

        return earthObj;
    }
}
