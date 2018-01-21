package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("JANUARY 1 2000"));
    }

    public static boolean isDateOdd(String date)
    {
        Date dateOfYear = new Date();
        dateOfYear.setHours(0);
        dateOfYear.setMinutes(0);
        dateOfYear.setSeconds(0);
        dateOfYear.setDate(1);
        dateOfYear.setMonth(0);

        Date currentDate = new Date(date);

        long value = currentDate.getTime() - dateOfYear.getTime();
        long oneDay = 60 * 60 * 24 * 1000;

        long result = value / oneDay;

        if(result % 2 == 0) return true;
        else return false;
    }
}
