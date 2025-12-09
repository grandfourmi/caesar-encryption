package com.javarush.exception;

public class CaesarException extends Exception {


    // проверяемые исключения
    public CaesarException(String message) {
        //Вызвать конструктор родителя с сообщением
        super(message);
    }
    // непроверяемые исключения
    public CaesarException(String message, Throwable cause) {
        // вызвать конструктора родителя с сообщением и причиной
        super(message, cause);

    }
}
