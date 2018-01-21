package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Maxim on 20.10.2015.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    public void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
