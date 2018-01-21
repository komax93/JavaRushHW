package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    private String threadName;

    @Override
    public void run() {
            try
            {
                while(!thread.isInterrupted())
                {
                    System.out.println(threadName);
                    Thread.sleep(100);
                }
            }
            catch (InterruptedException e){}
    }

    @Override
    public void stop()
    {
        thread.interrupt();
    }

    @Override
    public void start(String threadName)
    {
        this.threadName = threadName;
        thread = new Thread(this);
        thread.start();
    }
}
