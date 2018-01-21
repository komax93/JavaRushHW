package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/


import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        Scanner scan = new Scanner(new File(filename));
        ArrayList<Integer> list = new ArrayList<Integer>();

        while(scan.hasNextInt())
            list.add(scan.nextInt());

        sort(list);
        myPrint(list);

        OutputStream output = new FileOutputStream("C:\\Users\\Maxim\\res.txt");
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) % 2 == 0)
            {
                String str = Integer.toString(list.get(i));
                output.write((str + "\r\n").getBytes());
            }
        }
    }

    public static void sort(ArrayList<Integer> array)
    {
        for(int i = 0; i < array.size(); i++)
            for(int j = 0; j < array.size() - 1; j++)
                if(array.get(j) > array.get(j + 1))
                {
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
    }

    public static void myPrint(ArrayList<Integer> array)
    {
        for(int i = 0 ; i < array.size(); i++)
            if(array.get(i) % 2 == 0)
                System.out.println(array.get(i));
    }
}
//C:\Users\Maxim\te.txt