package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main(String[] args)
    {
        /*Map<String, String> params = new LinkedHashMap<>();
        params.put("name", "Ivanov");
        params.put("country", "UA");
        params.put("city", "Kiev");
        params.put("age", null);
        System.out.println(getCondition(params).toString());

        Map<String, String> params_2 = new LinkedHashMap<>();
        params.put("city", null);
        params.put("age", null);
        System.out.println(getCondition(params_2).toString());*/

        //width = 5; height = 3;
        int width = 5;
        int height = 3;
        for(int i = 0; i < height; i++)
            for(int j = 0; j < width; j++)
            {
                System.out.print("X");

                if((j + 1) % width == 0)
                    System.out.println();
            }

    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder strBuilder = new StringBuilder();
        for(Map.Entry<String, String> v : params.entrySet())
        {
            if (v.getValue() != null)
                strBuilder.append(v.getKey()).append(" = '").append(v.getValue()).append("' and ");
        }

        if(strBuilder.length() > 0)
            strBuilder.replace(strBuilder.length() - 5, strBuilder.length(), "");

        return strBuilder;
    }
}
