package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Maxim on 16.10.2015.
 */
public class Computer
{
    private Keyboard k;
    private Mouse m;
    private Monitor mon;

    public Computer()
    {
        this.k = new Keyboard();
        this.m = new Mouse();
        this.mon = new Monitor();
    }

    public Keyboard getKeyboard()
    {
        return k;
    }

    public Mouse getMouse()
    {
        return m;
    }

    public Monitor getMonitor()
    {
        return mon;
    }
}
