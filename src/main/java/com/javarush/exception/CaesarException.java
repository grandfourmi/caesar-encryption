package com.javarush.exception;

public class CaesarException extends Exception {

    public CaesarException(String message) {
        //Вызвать конструктор родителя с сообщением
        super(message);
        System.out.println(message);
    }

    public CaesarException(String message, Throwable cause) {
        // вызвать конструктора родителя с сообщением и причиной
        super(message, cause);

    }
}
