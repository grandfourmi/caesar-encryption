package com.javarush.service;
import com.javarush.exception.CaesarException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class FileService {

    public String readFile (String filePath) throws CaesarException {

        try {
            // 1 преобразовать путь в Path
            Path path = Path.of(filePath);
            // 2 проверить существование
            if (!Files.exists(path)) {
                throw new CaesarException("File not found" + filePath);
            }
            // 3 проверить права на чтение
            if (!Files.isRegularFile(path)) {
                throw new CaesarException("File is not a regular file" + filePath);
            }
            // todo 4  проверить содержимое

            return Files.readString(path);

            // 5 Обработать IOExxeption
        } catch (IOException e) {
            throw new CaesarException("Ошибка чтения файла" + e.getMessage(), e);
        }

    }

    public void writeFile (String filePath, String content) throws CaesarException  {
        // запись файла с созданием дирр
        try {
            // 1 преобразовать путь
            Path path = Path.of(filePath);

            Path parentDir = path.getParent();
            // 2 создать родительские дирр (опция)
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }

            // 3 записать содержимое с правильными опциями
            // todo прочитать что значит строчка снизу
            Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException e ) {
            // 4 обработать IOException
            throw new CaesarException("Ошибка записи файла" + e.getMessage(), e );
        }
    }

    public boolean fileExists(String filePath)  {
        return  Files.exists(Path.of(filePath));
    }
}
