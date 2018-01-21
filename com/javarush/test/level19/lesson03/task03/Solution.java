package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static class IncomeDataAdapter implements Customer, Contact
    {
        private IncomeData incData;
        public IncomeDataAdapter(IncomeData incData)
        {
            this.incData = incData;
        }

        public String getCompanyName()
        {
            return this.incData.getCompany();
        }

        public String getCountryName()
        {
            String code = this.incData.getCountryCode();
            String country = "";
            for(Map.Entry<String, String> key : countries.entrySet())
            {
                if(key.getKey().equals(code))
                    country = key.getValue();
            }

            return country;
        }

        public String getName()
        {
            return this.incData.getContactLastName() + ", " + this.incData.getContactFirstName();
        }

        public String getPhoneNumber()
        {
            String m = String.format("+%d(%2$s)%3$s-%4$s-%5$s", incData.getCountryPhoneCode(),
                    String.format("%010d", incData.getPhoneNumber()).substring(0, 3),
                    String.format("%010d", incData.getPhoneNumber()).substring(3, 6),
                    String.format("%010d", incData.getPhoneNumber()).substring(6, 8),
                    String.format("%010d", incData.getPhoneNumber()).substring(8));

            return m;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}