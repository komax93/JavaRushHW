package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Maxim on 15.10.2015.
 */
public class BelarusianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 5;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
