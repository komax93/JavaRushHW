package com.javarush.test.level22.lesson07.task03;

import java.util.*;

/* Форматирование даты
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Должен быть вывод аналогичный следующему:
31:10:13 15:59:59
*/
public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59 - dd:MM:yy hh:mm:ss

        int[] array = {3, 4, 2, 20, 11, 32, 1};

        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array.length - 1; j++)
                if(array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

        System.out.println();
        int value = 123;
        System.out.println(Integer.toBinaryString(value));
        System.out.format("%o", 123);
    }

    public static String getFormattedString() {
        return "%td:%tm:%ty %tH:%tM:%tS";
    }
}
