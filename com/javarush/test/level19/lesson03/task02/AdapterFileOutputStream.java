package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream fout;
    public AdapterFileOutputStream(FileOutputStream out)
    {
        this.fout = out;
    }

    public void flush() throws IOException
    {
        this.fout.flush();
    }

    public void writeString(String s) throws IOException
    {
        this.fout.write(s.getBytes());
    }

    public void close() throws IOException
    {
        this.fout.close();
    }
}

