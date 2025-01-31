package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Данный класс обязан использовать StreamApi из функционала Java 8. Функциональность должна быть идентична
 * {@link SimpleTextStatisticsAnalyzer}.
 */
public class StreamApiTextStatisticsAnalyzer implements TextStatisticsAnalyzer {
    @Override
    public int countSumLengthOfWords(String text) {
        return 0;
    }

    @Override
    public int countNumberOfWords(String text) {
        return 0;
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return 0;
    }

    @Override
    public List<String> getWords(String text) {
        return null;
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        return null;
    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        return null;
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        return null;
    }
}
