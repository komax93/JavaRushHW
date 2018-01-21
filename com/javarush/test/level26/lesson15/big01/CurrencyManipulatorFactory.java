package com.javarush.test.level26.lesson15.big01;

import java.util.*;
/**
 * Created by Maxim on 27.02.2016.
 */
public class CurrencyManipulatorFactory
{
    private static Map<String, CurrencyManipulator> map = new HashMap<String, CurrencyManipulator>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if(map.containsKey(currencyCode))
            return map.get(currencyCode);
        else
        {
            CurrencyManipulator current = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, current);
            return current;
        }
    }

    private CurrencyManipulatorFactory(){}

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return map.values();
    }
}
