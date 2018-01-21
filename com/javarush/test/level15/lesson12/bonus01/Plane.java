package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Maxim on 20.10.2015.
 */
public class Plane implements Flyable
{
    private int countOfPassengers;
    public Plane(int count)
    {
        this.countOfPassengers = count;
    }
    public void fly(){}
}
