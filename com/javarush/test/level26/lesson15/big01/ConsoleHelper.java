package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by Maxim on 27.02.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String str = "";
        try
        {
            str = reader.readLine();
            if("exit".equalsIgnoreCase(str))
                throw new InterruptOperationException();
        }
        catch (IOException ignored)
        {

        }

        return str;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage("Insert money code");
        String str = "";

        while(true)
        {
            str = readString();
            if(str.length() == 3)
                break;
            else
                writeMessage("The value is not correct");
        }
        str = str.toUpperCase();

        return str;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage("Insert two positive integer numbers to " + currencyCode);
        String[] strArr;

        while(true)
        {
            String str = readString();
            strArr = str.split(" ");
            int a, b;

            try
            {
                a = Integer.parseInt(strArr[0]);
                b = Integer.parseInt(strArr[1]);
            }
            catch (Exception e){continue;}

            if(a <= 0 || b <= 0 || strArr.length > 2)
                continue;

            break;
        }
        return strArr;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        Operation operation;
        while (true)
        {
            int o = 0;
            try
            {
                o = Integer.parseInt(readString());
            }
            catch (InterruptOperationException e)
            {
                e.printStackTrace();
            }

            try
            {
                operation = Operation.getAllowableOperationByOrdinal(o);
            }
            catch (IllegalArgumentException e)
            {
                continue;
            }
            break;
        }

        return operation;
    }

    public static void showGoodBye()
    {
        ConsoleHelper.writeMessage("GoodBye!");
    }
}
