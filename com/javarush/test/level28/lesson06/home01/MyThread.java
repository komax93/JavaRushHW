package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Maxim on 08.03.2016.
 */
import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread
{
    private static AtomicInteger currentPrior = new AtomicInteger(0);

    public MyThread()
    {
        priority();
    }

    public MyThread(Runnable target)
    {
        super(target);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        priority();
    }

    public MyThread(String name)
    {
        super(name);
        priority();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        priority();
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        priority();
    }

    public void priority()
    {
        currentPrior.incrementAndGet();
        currentPrior.compareAndSet(11, 1);

        int threadPriority = currentPrior.get();

        if(getThreadGroup() != null)
        {
            if(threadPriority > getThreadGroup().getMaxPriority())
                threadPriority = getThreadGroup().getMaxPriority();
        }

        setPriority(threadPriority);
    }
}
