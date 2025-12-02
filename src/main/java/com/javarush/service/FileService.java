package com.javarush.service;

import com.javarush.exception.CaesarException;

public class FileService {

    public String readFile (String filePath) throws CaesarException {
        //чтение файла с валидацией
        // 1 преобразовать путь в Path
        // 2 проверить существование файла
        // 3 проверить права на чтение
        // 4 проверить содержимое
        // 5 обработать IOexception
        return null;
    }

    public void writeFile (String filePath, String content) throws CaesarException {
    // запись файла с созданием дирр
        // 1 преобразовать путь
        // 2 создать родительские дирр (опция)
        // 3 записать содержимое с правильными опциями
        // 4 обработать IOExeption
    }

    public boolean fileExists(String filePath)  {
        // проверка существования файла
        return false;
    }
}
