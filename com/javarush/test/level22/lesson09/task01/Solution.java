package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedReader freader = new BufferedReader(new FileReader(filename));

        String line;
        ArrayList<String> list = new ArrayList<String>();
        while((line = freader.readLine()) != null)
        {
            String[] listArray = line.split(" ");
            for(String str : listArray)
                list.add(str);
        }

        for(int i = 0; i < list.size() - 1; i++)
        {
            StringBuilder str1 = new StringBuilder(list.get(i));
            StringBuilder str2 = new StringBuilder(list.get(i + 1));

            if(str1.toString().equals(str2.reverse().toString()))
            {
                if(list.get(i) == null || list.get(i + 1) == null)
                    continue;

                Pair pp = new Pair();
                pp.first = str1.toString();
                pp.second = str2.reverse().toString();

                if(!result.contains(pp))
                    result.add(pp);
            }
        }

        System.out.println(result);

        reader.close();
        freader.close();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            if (second != null ? !second.equals(pair.second) : pair.second != null) return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
    }

}
