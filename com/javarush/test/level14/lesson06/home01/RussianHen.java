package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Maxim on 15.10.2015.
 */
public class RussianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 4;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
