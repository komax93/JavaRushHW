package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import java.math.BigDecimal;

public class Solution {
    public Solution(String a)
    {

    }

    public Solution(Object a)
    {

    }

    public Solution(Integer a)
    {

    }

    protected Solution(int b)
    {

    }

    protected Solution(double b)
    {

    }

    protected Solution(char b)
    {

    }

    Solution(Character c)
    {

    }

    Solution(Byte c)
    {

    }

    Solution(Long c)
    {

    }

    private Solution(BigDecimal a)
    {

    }

    private Solution(Short a)
    {

    }

    private Solution(short a)
    {

    }
}

