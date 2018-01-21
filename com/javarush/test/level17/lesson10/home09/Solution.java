package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();

        Scanner data1 = new Scanner(new File(name1));
        Scanner data2 = new Scanner(new File(name2));

        while(data1.hasNextLine())
        {
            allLines.add(data1.nextLine());
        }

        while(data2.hasNextLine())
        {
            forRemoveLines.add(data2.nextLine());
        }

        new Solution().joinData();
    }

    public void joinData () throws CorruptedDataException
    {
        if(allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
            return;
        }

        for(String str : forRemoveLines)
            if(!allLines.contains(str))
            {
                allLines.clear();
                throw new CorruptedDataException();
            }
    }
}

//C:\Users\Maxim\res.txt
//C:\Users\Maxim\te.txt