package com.javarush.core;


import com.javarush.exception.CaesarException;


public class CaesarCoder {

    public String encodeText (String text, int shift) throws CaesarException {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            char temp;
            int shiftChar = shift + (int) ch;

            if ((int) ch > 1039 && (int) ch < 1104) temp = encodeLetterRuss(shiftChar);
            else if ((ch > 64 && ch < 91) || (ch > 96 && ch < 123)) temp = encodeLetterEng(shift, ch);
            else  temp = ch;

            result.append(temp); /* делаем сдвиг по цезарю*/
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
            char temp;
            int shiftChar = (int) ch - shift;

            if ((int) ch > 1039 && (int) ch < 1104) temp = deCodeLetterRuss(shiftChar);
            else if ((ch > 64 && ch < 91) || (ch > 96 && ch < 123)) temp = deCodeLetterEng(shift, ch);
            else  temp = ch;

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

    private char encodeLetterRuss(int shift) {
    char res ;
    if (shift > 1103) {
            shift = shift - 1103 + 1040;
            res = (char) (shift);
        } else  {
            res = (char) (shift);
        }
    return res;

}
    private char encodeLetterEng(int shift, char ch) {
        char res;
        int shiftChar = shift + (int) Character.toLowerCase(ch);
        if (shiftChar > 122) {
            shiftChar = shiftChar - 122 + 97;
            res = (char) (shiftChar);
        }  else  {
            res = (char) (shiftChar);
        }

        return res;
    }

    private char deCodeLetterRuss(int shift) {
        char res ;
        if (shift < 1041) {
            shift = shift - 1040 + 1103;
            res = (char) (shift);
        } else  {
            res = (char) (shift);
        }
        return res;

    }


    private char deCodeLetterEng(int shift, char ch) {
        char res;
        int shiftChar = shift - (int) Character.toLowerCase(ch);
        if (shiftChar < 97) {
            shiftChar = shiftChar - 97 + 122;
            res = (char) (shiftChar);
        }  else  {
            res = (char) (shiftChar);
        }
        return res;
    }
    }



