package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;

        if(first != null ? !first.equals(solution.first) : solution.first != null)
            return false;
        if(last != null ? !last.equals(solution.last) : solution.last != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<Solution>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
