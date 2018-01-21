package com.javarush.test.level26.lesson15.big01.command;

/**
 * Created by Maxim on 27.02.2016.
 */

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

class InfoCommand implements Command
{
    @Override
    public void execute()
    {
        boolean hMoney = false;
        for(CurrencyManipulator c: CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (c.hasMoney())
            {
                ConsoleHelper.writeMessage(c.getCurrencyCode() + " - " + c.getTotalAmount());
                hMoney = true;
            }
        }

        if(!hMoney)
            ConsoleHelper.writeMessage("No money available.");
    }
}
