package com.epam.izh.rd.online.helper;

import java.util.Comparator;

public class SortByLength implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        return left.length() == right.length() ? left.compareTo(right) : left.length() - right.length();
    }
}
