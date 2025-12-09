package com.javarush.core;

import java.util.*;


// тут все очень приблизительно

public class Alphabet {

    public static final Set<Character> ALPHABET_SET; // инициализировать алфавит
    //public static final Map<Character,Character> ALPHABET1 ;
    private static final char[] ALPHABET_ARRAY;

    static {
        ALPHABET_SET = new  HashSet<>(Arrays.asList('а', 'б',
                'в','г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
                'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
                '"', '\'', ':', '!', '?', ' '));
        ALPHABET_ARRAY = new char[] {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
                'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

        // создать временные хэмапы

        // заполнить цифры
        // создать обратное отображение


    }

    private Alphabet() {
        // запрет создания утилитарный класс
    }

    public static Set<Character> getAlphabet() {
        return ALPHABET_SET;
    }
}
