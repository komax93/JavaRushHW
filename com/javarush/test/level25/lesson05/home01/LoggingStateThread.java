package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Maxim on 23.01.2016.
 */
public class LoggingStateThread extends Thread
{
    private Thread thread;

    public LoggingStateThread(Thread thread)
    {
        setDaemon(true);
        this.thread = thread;
    }

    public void run()
    {
        State state = thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if(state != thread.getState())
            {
                state = thread.getState();
                System.out.println(state);
            }
        }
    }
}
