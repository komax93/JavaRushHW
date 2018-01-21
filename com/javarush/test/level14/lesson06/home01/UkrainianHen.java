package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Maxim on 15.10.2015.
 */
public class UkrainianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 8;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
