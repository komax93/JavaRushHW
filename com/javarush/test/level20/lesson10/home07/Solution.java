package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String textFile;

    public static void main(String[] args) throws Exception
    {
        Solution s = new Solution("C:\\Users\\Maxim\\res.txt");
        s.writeObject("Maxym");
        s.close();

        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Maxim\\te.txt"));
        objOut.writeObject(s);
        objOut.flush(); //-удалить
        objOut.close();

        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("C:\\Users\\Maxim\\te.txt"));
        Solution s2 = (Solution) objIn.readObject();
        objIn.close();

        s2.writeObject("Kolesnykov");
        s2.writeObject("Andrejchyk");
        s2.close();
    }

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.textFile = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.textFile, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
