package com.javarush.service;

import com.javarush.exception.CaesarException;

public class ValidationService {

    public void validateTextForEncoding (String text) throws CaesarException {
        // Валидация текста для кодирования
        // 1 проверить на null и пустоту
        // 2 пройти по всем символам
        // 3 проверить наличие в алфавите
        // 4 выбросить исключение с инфо о позиции ошибки
    }

    public void validateCaesarCode (String caesarCode) throws CaesarException {
        // валидация кода Цезаря
        // 1 проверить на null и пустоту
        // 2 разбить на отдельные коды
        // 3 проверить каждый код (кроме разделителя слов)
        // 4 Выбросить исключение с инфо о позиции ошибки
    }
}
