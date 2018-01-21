package com.javarush.test.level08.lesson11.home05;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        s = toFirstUpperString(s);
        System.out.println(s);
    }

    public static String toFirstUpperString(String s)
    {
        char[] charArray = s.toCharArray();

        if(Character.isLetter(charArray[0]))
            charArray[0] = Character.toUpperCase(charArray[0]);

        for(int i = 1; i < s.length() - 1; i++)
            if(charArray[i - 1] == ' ' && charArray[i] != ' ')
                charArray[i] = Character.toUpperCase(charArray[i]);

        String retStr = new String(charArray);

        return retStr;
    }
}
