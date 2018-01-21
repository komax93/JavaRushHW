package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Maxim on 05.03.2016.
 */

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order
{
    private Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString()
    {
        if(dishes == null || dishes.isEmpty())
            return "";

        return "Your order: " + dishes.toString() +  " of " + tablet;
    }

    public boolean isEmpty() {
        return dishes == null || dishes.isEmpty();
    }
}
