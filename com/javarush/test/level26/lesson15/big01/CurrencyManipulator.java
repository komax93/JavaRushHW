package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Maxim on 27.02.2016.
 */
import java.util.*;

public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if(denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination, count);
    }

    public int getTotalAmount()
    {
        int result = 0;

        for(Map.Entry<Integer, Integer> m: denominations.entrySet())
        {
            result += m.getKey() * m.getValue();
        }

        return result;
    }

    public boolean hasMoney()
    {
        return denominations.size() > 0;
    }
}
