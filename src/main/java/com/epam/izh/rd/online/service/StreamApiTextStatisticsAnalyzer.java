package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;
import com.epam.izh.rd.online.helper.SortByLength;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Данный класс обязан использовать StreamApi из функционала Java 8. Функциональность должна быть идентична
 * {@link SimpleTextStatisticsAnalyzer}.
 */
public class StreamApiTextStatisticsAnalyzer implements TextStatisticsAnalyzer {
    @Override
    public int countSumLengthOfWords(String text) {
        return getWords(text).stream().mapToInt(String::length).sum();
    }

    @Override
    public int countNumberOfWords(String text) {
        return (int)getWords(text).stream().count();
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return (int)getUniqueWords(text).stream().count();
    }

    @Override
    public List<String> getWords(String text) {
        return new ArrayList<>(Arrays.asList(text.split("\\W+")));
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        return getWords(text).stream().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        return getUniqueWords(text).stream()
                                   .collect(Collectors.toMap(uniqueWord -> uniqueWord,
                                                             uniqueWord -> getRepetitionsCount(text, uniqueWord)));
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        List<String> words = getWords(text).stream().sorted(new SortByLength()).collect(Collectors.toList());
        if (direction.equals(Direction.DESC)) {
            Collections.reverse(words);
        }
        return words;
    }

    private Integer getRepetitionsCount(String text, String word) {
        List<String> allWords = getWords(text);
        return (int)allWords.stream().filter(wordFromAllWords -> wordFromAllWords.equals(word)).count();
    }
}
