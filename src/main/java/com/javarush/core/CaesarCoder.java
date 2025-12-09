package com.javarush.core;

import com.javarush.model.ProcessingResult;
import com.javarush.exception.CaesarException;
import com.javarush.service.ValidationService;


public class CaesarCoder {

    private final ValidationService validationService;

    public CaesarCoder() {
        this.validationService = new ValidationService();
    }


    public ProcessingResult encodeText (String text) throws CaesarException {
        // тут подумать над логикой реализации

        // кодирование текста в цезаря
        // 1 валидировать входной текст
        validationService.validateTextForEncoding(text);
        // 2 провести к верхнему регистру
        String upperText = text.toUpperCase();
        StringBuilder result = new StringBuilder();

        // 3 пройти по всем символам
        for (int i = 0; i < upperText.length(); i++) {
            char ch = upperText.charAt(i);
            /* делаем сдвиг по цезарю*/
            // todo сделать реализацию
            // 4 найти код Море для каждого символа
            result.append(Alphabet.getAlphabet());
        }

        String encodedText = result.toString();
        // 6 вернуть ProcessingResult
        return  new ProcessingResult(true,"Текст успешно закодирован",
                getPreview(text),getPreview(encodedText));
    }

    public ProcessingResult decodeText (String caesarCode) throws CaesarException {

        // декодирование реализация по морзе
        // 1 валидировать входной код
        validationService.validateCaesarCode(caesarCode);

        // 2 разбить на отдельные символы
        StringBuilder result = new StringBuilder();
        String [] symbols = caesarCode.trim().split(" ");

        // 3 найти букву для каждого символа
        for (String symbol : symbols) {
            if (Alphabet.getAlphabet().contains(symbol)) {
                result.append(symbol);
            } else if (symbol.equals("/")) {
                result.append("/");
            }
        }


        // 4 обработать разделитель слов
        // 5 собрать результат
        // 6 вернуть ProcessingResult
        String decodedText = result.toString();

        return new ProcessingResult(true, "Код успешно декодирован",
                getPreview(caesarCode), getPreview(decodedText));
    }

    public String getPreview (String text) {

        if (text.length() <= 100) return text;

        return text.substring(0, 97) + "...";
    }
}
