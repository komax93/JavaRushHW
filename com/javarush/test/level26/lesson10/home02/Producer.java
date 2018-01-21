package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Maxim on 23.02.2016.
 */
public class Producer implements Runnable
{
    private static int value = 1;
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    public void run()
    {
        try
        {
            int i = 1;
            while(true)
            {
                System.out.println("Some text for " + i++);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(Thread.currentThread().getName() + "thread was terminated");
        }
    }
}
