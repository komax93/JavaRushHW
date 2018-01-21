package com.javarush.test.level20.lesson10.bonus01;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        int result[] = null;
        int result1[] = new int[N];
        int count = 0;

        for(int i = 1; i <= N; i++)
        {
            String str = Integer.toString(i);
            int M = str.length();
            int currentValue = i;
            int tempSum = 0;
            while (currentValue != 0)
            {
                int res = currentValue % 10;
                tempSum += Math.pow(res, M);
                currentValue = currentValue / 10;
            }

            if (tempSum == i)
            {
                result1[count++] = i;
            }
        }

        result = new int[count];
        for(int i = 0; i < count; i++)
            result[i] = result1[i];

        return result;
    }

    public static void main(String[] args)
    {
        int array[] = getNumbers(370);
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
}
