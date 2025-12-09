package com.javarush.service;

import com.javarush.exception.CaesarException;

 //   ОЗНАКОМИТЬСЯ С ТЗ И УБЕДИТЬСЯ В НЕОБХОДИМОСТИ ЭТОГО КЛАССА

    public class ValidationService {

    //public void validateTextForEncoding (String text) throws CaesarException {
      public void validateTextForEncoding(String text) throws CaesarException {
        // todo Валидация текста для кодирования
        // 1 проверить на null и пустоту
        if(text == null || text.trim().isEmpty()){
            throw new CaesarException("Null or empty text");
        }
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
