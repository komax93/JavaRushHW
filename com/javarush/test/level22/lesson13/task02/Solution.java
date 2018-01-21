package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String filename1 = args[0];
        String filename2 = args[1];

        Charset win1251 = Charset.forName("WINDOWS-1251");
        Charset utf8 = Charset.forName("UTF-8");

        FileInputStream fInput = new FileInputStream(filename1);
        FileOutputStream fOutput = new FileOutputStream(filename2);

        byte[] buffer = new byte[fInput.available()];
        fInput.read(buffer);

        String str = new String(buffer, "UTF-8");
        fOutput.write(str.getBytes("WINDOWS-1251"));




        fInput.close();
        fOutput.close();
    }
}
