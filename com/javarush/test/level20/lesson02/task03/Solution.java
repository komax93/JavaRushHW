package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<String, String>();
    public static List<User> list = new ArrayList<User>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        list.add(new User("Roman", "Skrypyn"));
        list.add(new User("Ihor", "Kolomoysky"));
        list.add(new User("Maksym", "Kolesnykov"));

        User u = new User();
        u.save(new FileOutputStream(filename));
    }

    public static class User
    {
        private String firstName;
        private String lastName;

        public User(){}

        public User(String fName, String lName)
        {
            this.firstName = fName;
            this.lastName = lName;
        }

        public String getFirstNameName()
        {
            return firstName;
        }

        public void setFirstName(String firstName)
        {
            this.firstName = firstName;
        }

        public String getLastName()
        {
            return lastName;
        }

        public void setLastName(String lastName)
        {
            this.lastName = lastName;
        }

        public void save(OutputStream outputStream)
        {
            PrintWriter printWriter = new PrintWriter(outputStream);

            for(User u : list)
            {
                printWriter.println("@");
                String firstName = u.getFirstNameName();
                if (firstName == null)
                    firstName = "noFirstName";

                String lastName = u.getLastName();
                if (lastName == null)
                    lastName = "noLastName";

                printWriter.println(firstName);
                printWriter.println(lastName);
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws IOException
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while(reader.ready())
            {
                User myUser = new User();
                if ("@".equals(reader.readLine()))
                {
                    String fName = reader.readLine();
                    if (!fName.equals("noFirstName"))
                        myUser.setFirstName(fName);
                    else
                        myUser.setFirstName(null);

                    String lName = reader.readLine();
                    if (!lName.equals("noLastName"))
                        myUser.setLastName(lName);
                    else
                        myUser.setLastName(null);
                }
                list.add(myUser);
            }
        }
    }
}

