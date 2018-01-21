package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Maxim on 27.02.2016.
 */
import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);

        try
        {
            CurrencyManipulator currencyManipulator;
            Operation operation;
            do
            {

                ConsoleHelper.writeMessage("1 - INFO;");
                ConsoleHelper.writeMessage("2 - DEPOSIT;");
                ConsoleHelper.writeMessage("3 - WITHDRAW;");
                ConsoleHelper.writeMessage("4 - EXIT;");
                ConsoleHelper.writeMessage("Chose your operation: ");


                int numberOfOperation = Integer.parseInt(ConsoleHelper.readString());

                operation = Operation.getAllowableOperationByOrdinal(numberOfOperation);
                CommandExecutor.execute(operation);
            }
            while (true);
        }
        catch(InterruptOperationException e)
        {
            ConsoleHelper.writeMessage("GoodBye");
        }
    }
}

