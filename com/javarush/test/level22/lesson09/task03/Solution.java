package com.javarush.test.level22.lesson09.task03;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws Exception{
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedReader freader = new BufferedReader(new FileReader(filename));

        String line;
        ArrayList<String> arrList = new ArrayList<String>();
        while((line = freader.readLine()) != null)
        {
            String[] arrLine = line.split(" ");
            for(String value : arrLine)
                arrList.add(value);
        }
        String[] wordsArray = new String[arrList.size()];
        wordsArray = arrList.toArray(wordsArray);

        StringBuilder result = getLine(wordsArray);
        System.out.println(result.toString());

        reader.close();
        freader.close();
    }

    public static StringBuilder getLine(String... words)
    {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, words);
        StringBuilder strBuilder = new StringBuilder();
        if(list.size() == 0)
            return new StringBuilder();

        for(int i = 0; i < list.size(); i++)
            for(int j = 0; j < list.size() - 1; j++)
                if(list.get(j).compareToIgnoreCase(list.get(j + 1)) > 0)
                {
                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }


        strBuilder.append(list.get(0));
        list.remove(0);

        while(list.size() > 0)
        {
            for(int i = 0; i < list.size(); i++)
            {
                String temp = strBuilder.toString().toLowerCase();
                if (temp.charAt(temp.length() - 1) == list.get(i).toLowerCase().charAt(0))
                {
                    strBuilder.append(" ").append(list.get(i));
                    list.remove(i);
                }
            }

        }

        return strBuilder;
    }
}
