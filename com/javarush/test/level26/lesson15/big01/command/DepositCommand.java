package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Maxim on 27.02.2016.
 */
class DepositCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        CurrencyManipulator currencyManipulator;

        String code = ConsoleHelper.askCurrencyCode();
        currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        String[] codeArr = ConsoleHelper.getValidTwoDigits(code);

        try
        {
            int a = Integer.parseInt(codeArr[0]);
            int b = Integer.parseInt(codeArr[1]);
            currencyManipulator.addAmount(a, b);
        }
        catch (NumberFormatException e){}
    }
}
