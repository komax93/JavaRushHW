package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(buffer.readLine());
        int b = Integer.parseInt(buffer.readLine());
        int c = Integer.parseInt(buffer.readLine());

        int min = 0, max = 0, middle = 0;
        if(a > b && a > c) max = a;
        if(b > a && b > c) max = b;
        if(c > a && c > b) max = c;

        if(a < b && a < c) min = a;
        if(b < a && b < c) min = b;
        if(c < a && c < b) min = c;

        if(a > min && a < max) middle = a;
        if(b > min && b < max) middle = b;
        if(c > min && c < max) middle = c;

        System.out.print(middle);
    }
}
