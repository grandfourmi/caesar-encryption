package com.javarush.service;
import com.javarush.exception.CaesarException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileService {

    public BufferedInputStream readFile (String filePath) throws CaesarException {
        //чтение файла с валидацией
        Path path = Path.of(filePath);// 1 преобразовать путь в Path

        if (!Files.isReadable(path)) {       // 3 проверить права на чтение
            CaesarException caesarException = new CaesarException("File not found");
        }

        FileInputStream stream = null;

        try {
            stream = new FileInputStream(path.toFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);


        // 4 проверить содержимое

        return bufferedInputStream;
    }

    public void writeFile (String filePath, String content) throws CaesarException  {
        // запись файла с созданием дирр
        Path path = Path.of(filePath); // 1 преобразовать путь

        // 2 создать родительские дирр (опция)
        // 3 записать содержимое с правильными опциями
        // 4 обработать IOExeption
    }

    public boolean isFilesExists(String filePath)  {
        File file = new File(filePath); // проверка существования файла
        return file.exists();
    }
}
