package com.javarush.service;

import com.javarush.exception.CaesarException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class FileService {

    public String readFile(String filePath) throws CaesarException {

        try {
            Path path = Path.of(filePath);

            if (!Files.exists(path)) {
                throw new CaesarException("Файл не найден " + filePath);
            }

            if (!Files.isRegularFile(path)) {
                throw new CaesarException("Нет доступа для чтения этого файла " + filePath);
            }

            return Files.readString(path);

        } catch (IOException | InvalidPathException e) {
            throw new CaesarException("Ошибка чтения файла" + e.getMessage(), e);
        }

    }

    public void writeFile(String filePath, String content) throws CaesarException {
        try {
            Path path = Path.of(filePath);
            Path parentDir = path.getParent();

            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }
            Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException | InvalidPathException e) {
            throw new CaesarException("Ошибка записи файла " + e.getMessage(), e);
        }
    }

}
