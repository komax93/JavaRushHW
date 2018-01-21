package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Maxim on 27.02.2016.
 */
class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Are you really want to exit <y,n>?");

        if(ConsoleHelper.readString().trim().equalsIgnoreCase("y"))
            ConsoleHelper.writeMessage("GoodBye");

    }
}
