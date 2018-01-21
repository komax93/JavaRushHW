package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Maxim on 13.12.2015.
 */
public class Hippodrome
{
    public static ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse h1 = new Horse("Sonja", 3, 0);
        Horse h2 = new Horse("Komax", 3, 0);
        Horse h3 = new Horse("Ilo", 3, 0);

        horses.add(h1);
        horses.add(h2);
        horses.add(h3);

        game.run();
        game.printWinner();
    }

    public void run()
    {
        for(int i = 1; i <= 100; i++)
        {
            move();
            print();

            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e){}
        }
    }

    public void move()
    {
        for(int i = 0; i < horses.size(); i++)
            horses.get(i).move();
    }

    public void print()
    {
        for(int i = 0; i < horses.size(); i++)
            horses.get(i).print();

        System.out.println();
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public Horse getWinner()
    {
        double max = 0;
        Horse winner = null;
        for(int i = 0; i < horses.size(); i++)
            if(max < horses.get(i).getDistance())
            {
                max = horses.get(i).getDistance();
                winner = horses.get(i);
            }

        return winner;
    }

    public void printWinner()
    {
        Horse winner = getWinner();
        System.out.println("Winner is " + winner.getName() + "!");
    }
}
