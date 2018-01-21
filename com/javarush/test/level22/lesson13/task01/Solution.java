package com.javarush.test.level22.lesson13.task01;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        String str = "Hellow, World";
        char[] toCharArray = new char[str.length()];

        int N = toCharArray.length;
        for(int i = 0; i < N / 2; i++)
        {
            char temp = toCharArray[i];
            toCharArray[i] = toCharArray[N - i - 1];
            toCharArray[N - i - 1] = temp;
        }

        str = String.valueOf(toCharArray);
        System.out.println(str);
    }

    public static void getCopy(File file1, File file2) throws IOException
    {
        Files.copy(file1.toPath(), file2.toPath());
    }

    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] array = new String[tokenizer.countTokens()];
        int i = 0;
        while(tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            array[i++] = token.toString();
        }
        return array;
    }
}
