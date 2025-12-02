package com.javarush.core;

import com.javarush.ProcessingResult;
import com.javarush.exception.CaesarException;
import com.javarush.service.ValidationService;

public class CaesarCoder {

    private final ValidationService validationService;

    public CaesarCoder(ValidationService validationService) {

        //  инициализировать валидатьон сервис
        this.validationService = validationService;
    }


    public ProcessingResult encodeText (String text) throws CaesarException {
        // тут подумать над логикой реализации

        // кодирование текста в цезаря
        // 1 валидировать входной текст
        // 2 провести к верхнему регистру
        // 3 пройти по всем символам
        // 4 найти код Море для каждого символа
        // 5 собрать результат с пробелами
        // 6 вернуть ProcessingResult

        return null;
    }

    public ProcessingResult decodeText (String caesarCode) throws CaesarException {
        // тут подумать над логикой реализации

        // декодирование цезаря в текст
        // 1 валидировать входной код
        // 2 провести к верхнему регистру
        // 3 пройти по всем символам
        // 4 найти код Море для каждого символа
        // 5 собрать результат с пробелама
        // 6 вернуть ProcessingResult

        return null;
    }

    public String getPreview (String text) {
        // создание превью текста
        // 1 если текст короткий вернуть как есть
        // 2 если длинный обрезать и добавить "...."
        return null;
    }
}
