package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        String filename1 = args[0];
        String filename2 = args[1];

        BufferedReader freader = new BufferedReader(new FileReader(filename1));
        FileWriter fwriter = new FileWriter(filename2);

        String line;
        StringBuffer strBuff = new StringBuffer();
        while((line = freader.readLine()) != null)
        {
            String[] arrLine = line.split(" ");

            for(int i = 0; i < arrLine.length; i++)
                if(arrLine[i].length() > 6)
                    strBuff.append(arrLine[i] + ",");
        }
        strBuff.delete(strBuff.length() - 1, strBuff.length());
        String str = strBuff.toString();
        fwriter.write(str);

        freader.close();
        fwriter.close();
    }
}
