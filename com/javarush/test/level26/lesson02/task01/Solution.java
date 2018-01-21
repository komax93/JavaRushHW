package com.javarush.test.level26.lesson02.task01;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
import java.util.*;

public class Solution
{
    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        int N = array.length;
        final double Me;
        if(N % 2 == 0)
        {
            int numb1 = N / 2;
            int numb2 = (N / 2) - 1;
            Me = ((double)array[numb1] + (double)array[numb2]) / 2.0;
        }
        else
        {
            int numb = (N / 2);
            Me = (double)array[numb];
        }

        Comparator<Integer> compareByMediana = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double result = Math.abs(o1 - Me) - Math.abs(o2 - Me);
                if(result == 0)
                    result = o1 - o2;

                return (int) result;
            }
        };

        Arrays.sort(array, compareByMediana);
        return array;
    }
}
