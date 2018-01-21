package com.javarush.test.level26.lesson10.task01;

/**
 * Created by Maxim on 24.02.2016.
 */
public class MyClass
{
    public static void main(String[] args)
    {
        MyThread m = new MyThread();
        Thread myThread = new Thread(m);

        MyThread n = new MyThread();
        Thread nThread = new Thread(n);

        myThread.start();
        try
        {
            myThread.join();
        }
        catch (InterruptedException e){}
        nThread.start();
    }

    public static class MyThread implements Runnable
    {
        public void run()
        {
            try
            {
                for(int i = 0; i < 10; i++)
                {
                    System.out.println("Hellow World + " + Thread.currentThread().getName());
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e)
            {

            }
        }
    }
}
