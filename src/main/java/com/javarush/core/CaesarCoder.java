package com.javarush.core;


import com.javarush.exception.CaesarException;


public class CaesarCoder {

    public String encodeText (String text, int step) throws CaesarException {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {

            char temp;

            ch = Character.toLowerCase(ch);

            if (ch >= 'а' && ch <= 'я') {
                temp = encodeLetterRuss(step,ch);
            } else if (ch > 'a' && ch < 'z') {
                temp = encodeLetterEng(step, ch);
            } else {
                temp = ch;
            }
            result.append(temp);
        }

        String resultString = result.toString();

        System.out.println("Текст успешно закодирован:");
        System.out.println("Исходный файл: " + getPreview(text));
        System.out.println("Результат: " + getPreview(resultString));

        return resultString;
    }

    public String decodeText (String caesarCode, int shift) throws CaesarException {
        StringBuilder result = new StringBuilder();

        for (char ch : caesarCode.toCharArray()) {

            ch = Character.toLowerCase(ch);

            char temp;

            if (ch >= 'а' && ch <= 'я') {
                temp = deCodeLetterRuss(shift , ch);
            } else if (((int)ch > 96 && (int)ch < 123)) {
             temp = deCodeLetterEng(shift, ch);
            } else {
                temp = ch;
            }

            result.append(temp);
        }

        String resultString = result.toString();

        System.out.println("Текст успешно раскодирован:");
        System.out.println("Исходный файл: " + getPreview(caesarCode));
        System.out.println("Результат: " + getPreview(resultString));


        return resultString;
    }


    public String getPreview (String text) {

        if (text.length() <= 100) return text;

        return text.substring(0, 97) + "...";
    }

    private char encodeLetterRuss(int step, char ch) {
        step = step % 32;
        int a = 'а';
        int z = 'я';
        int shift = ch + step;

        if (shift > z)
            shift = a + (shift - z - 1);

        return (char) shift;
    }

    private char deCodeLetterRuss(int step, char ch) {
        step = step % 32;
        int a = 'а';
        int z = 'я';
        int shift = ch - step;

        if (shift < a)
            shift = z - (a - shift - 1);

        return (char) shift;
    }

    private char encodeLetterEng(int step, char ch) {
        step = step % 26;
        int a = 'a';
        int z = 'z';
        int shift = ch + step;

        if (shift > z)
            shift = a + (shift - z - 1);

        return (char) shift;
    }

    private char deCodeLetterEng(int step, char ch) {
        step = step % 26;
        int a = 'a';
        int z = 'z';
        int shift = ch - step;

        if (shift < a)
            shift = z - (a - shift - 1);

        return (char) shift;
    }

}



