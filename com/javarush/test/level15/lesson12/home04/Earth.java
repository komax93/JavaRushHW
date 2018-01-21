package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Maxim on 20.10.2015.
 */
public class Earth implements Planet
{
    private static Earth earthObj = null;

    private Earth(){}

    public  static Earth getInstance()
    {
        if(earthObj == null) earthObj = new Earth();

        return earthObj;
    }
}
