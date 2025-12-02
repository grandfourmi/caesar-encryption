package com.javarush.core;

import java.util.*;


// тут все очень приблизительно

public class Alphabet {

    public static final Set<Character> ALPHABETSET; // инициализировать алфавит
    //public static final Map<Character,Character> ALPHABET1 ;
    private static final char[] ALPHABETARRAY;

    static {
        ALPHABETSET = new  HashSet<>(Arrays.asList('а', 'б',
                'в','г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
                'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
                '"', '\'', ':', '!', '?', ' '));
        ALPHABETARRAY = new char[] {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
                'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

        // создать временные хэмапы

        // заполнить цифры
        // создать обратное отображение

;
    }

    private Alphabet() {
        // запрет создания утилитарный класс
    }

    public static Set<Character> getAlphabet() {
        return ALPHABETSET;
    }
}
