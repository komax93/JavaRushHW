package com.javarush.test.level20.lesson10.home03;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";
        public A(){}
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        public void writeObject(ObjectOutputStream obj) throws IOException
        {
            obj.defaultWriteObject();
            obj.writeObject(name);
        }

        public void readObject(ObjectInputStream obj) throws IOException, ClassNotFoundException
        {
            obj.defaultReadObject();
            name = (String) obj.readObject();
        }
    }
}
