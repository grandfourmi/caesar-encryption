package com.javarush.core;

import java.util.HashMap;
import java.util.Map;
// тут все очень приблизительно

public class Alphabet {

    public static final Map<Character, Character> ALPHABET ;
    public static final Map<Character,Character> ALPHABET1 ;

    static {
        // инициализировать  алфавитМорзе
        // создать временные хэмапы
        // заполнить русские буквы
        // заполнить цифры
        // создать обратное отображение
        // сделать коллекции неизменяемыми

        ALPHABET = null;
        ALPHABET1 = null;
    }

    private Alphabet() {
        // запрет создания утилитарный класс
    }

    public static Map<Character, Character> getAlphabet() {
        return ALPHABET;
    }
}
