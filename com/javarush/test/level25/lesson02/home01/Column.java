package com.javarush.test.level25.lesson02.home01;

import java.util.*;

public enum Column implements Columnable{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    @Override
    public String getColumnName()
    {
        return this.columnName;
    }

    @Override
    public boolean isShown()
    {
        if(this.realOrder[Column.this.ordinal()] != -1)
            return true;

        return false;
    }

    @Override
    public void hide()
    {
        this.realOrder[Column.this.ordinal()] = -1;
    }


    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new ArrayList<Column>();
        Map<Integer, Column> map = new TreeMap<Integer, Column>();
        for (int i = 0; i < realOrder.length; i++) {
            map.put(realOrder[i], Column.values()[i]);
        }

        for (Map.Entry<Integer, Column> entry : map.entrySet()){
            if (entry.getKey() != -1)
                result.add(entry.getValue());
        }
        return result;
    }
}
