package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem{
        private Customer cust;
        private Contact cont;

        public DataAdapter(Customer customer, Contact contact) {
            this.cust = customer;
            this.cont = contact;
        }

        public String getCountryCode()
        {
            String code = null;
            for(Map.Entry<String, String> key : countries.entrySet())
            {
                if(key.getValue().equals(this.cust.getCountryName()))
                    code = key.getKey();
            }

            return code;
        }

        public String getCompany()
        {
            return this.cust.getCompanyName();
        }

        public String getContactFirstName()
        {
            String str = this.cont.getName();
            String name = str.substring(str.lastIndexOf(",") + 2);

            return name;
        }

        public String getContactLastName()
        {
            String str = this.cont.getName();
            String name = str.substring(0, str.indexOf(","));

            return name;
        }

        public String getDialString()
        {
            String phone = "callto://" + this.cont.getPhoneNumber().replaceAll("[()-]","");
            return phone;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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