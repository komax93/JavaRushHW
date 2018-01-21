package com.javarush.test.level20.lesson02.task05;

import java.io.*;
import java.util.ArrayList;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static ArrayList<User> user = new ArrayList<User>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        user.add(new User("Ilo", "Bolkvadze"));
        user.add(new User("Resan", "Chogadze"));
        user.add(new User("Ihor", "Andrejchyk"));
        user.add(new User("Vasyl", "Andrejchyk"));

        User u = new User();
        u.save(new FileOutputStream(filename));
    }

    public static class User
    {
        private String firstName, lastName;

        public User(){}
        public User(String fName, String lName)
        {
            this.firstName = fName;
            this.lastName = lName;
        }

        public String getFirstName()
        {
            return firstName;
        }

        public String getLastName()
        {
            return lastName;
        }

        public void setFirstName(String firstName)
        {
            this.firstName = firstName;
        }

        public void setLastName(String lastName)
        {
            this.lastName = lastName;
        }

        public void save(OutputStream outputStream)
        {
            PrintWriter printWriter = new PrintWriter(outputStream);
            for(User u : user)
            {
                printWriter.println("@");
                if(u.getFirstName() != null)
                    printWriter.println(u.getFirstName());
                else
                    printWriter.println("noFName");

                if(u.getLastName() != null)
                    printWriter.println(u.getLastName());
                else
                    printWriter.println("noLName");
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws IOException
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while (bufferedReader.ready())
            {
                User u = new User();
                if("@".equals(bufferedReader.readLine()))
                {
                    String fName = bufferedReader.readLine();
                    if(!fName.equals("noFName"))
                        u.setFirstName(fName);
                    else
                        u.setFirstName(null);

                    String lName = bufferedReader.readLine();
                    if(!lName.equals("noLName"))
                        u.setLastName(lName);
                    else
                        u.setLastName(null);
                }
                user.add(u);
            }

            bufferedReader.close();
        }
    }

}
