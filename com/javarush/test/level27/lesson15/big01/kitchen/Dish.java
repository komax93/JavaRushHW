package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Maxim on 05.03.2016.
 */
public enum Dish
{
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        Dish[] dishes = Dish.values();
        for(int i = 0; i < dishes.length; i++)
        {
            stringBuilder.append(dishes[i].toString());
            if(i < (dishes.length - 1))
                stringBuilder.append(", ");
        }

        return stringBuilder.toString();
    }
}
