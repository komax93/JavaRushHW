package com.javarush.test.level26.lesson02.task03;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/

import java.util.*;

public class Solution
{
    public static class CustomizedComparator<T> implements Comparator<T>
    {
        private Comparator<T>[] listComparator;

        public CustomizedComparator(Comparator<T>... comparators)
        {
            this.listComparator = comparators;
        }

        @Override
        public int compare(T o1, T o2)
        {
            int result = 0;

            for(Comparator c : listComparator)
            {
                result = c.compare(o1, o2);
                if(result != 0)
                    break;
            }
            return result;
        }
    }
}
