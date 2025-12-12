package com.javarush;

import com.javarush.core.CaesarCoder;
import com.javarush.core.StatisticAnalyzeDecoder;
import com.javarush.exception.CaesarException;
import com.javarush.service.FileService;

import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.io.IOException;


// C:\JavaProject\CaesarCodding\caesar-codding\src\text\Gaar.txt
// C:\JavaProject\CaesarCodding\caesar-codding\src\text\encodedText.txt
public class CaesarApp {

    private final Scanner scanner;
    private final FileService fileService; //  поля класса - зависимости
    private final CaesarCoder caesarCoder;
    private final StatisticAnalyzeDecoder statisticAnalyzeDecoder;

    public CaesarApp() {
        this.scanner = new Scanner(System.in);
        this.fileService = new FileService();
        this.caesarCoder = new CaesarCoder();
        this.statisticAnalyzeDecoder = new StatisticAnalyzeDecoder();
    }


    static void main() {
        CaesarApp app = new CaesarApp();
        app.run();

    }

    public void run() {

        printWelcomeMessage();
        //    startMusic();

        while (true) {

            showMainMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    processEncodeFile();
                    break;
                case "2":
                    processDecodeFile();
                    break;
                case "3":
                    processBruteForce();
                    break;
                case "4":
                    processStatisticAnalyzeText();
                    break;
                case "5":
                    showCaesarInfo();
                    break;
                case "0":
                    processExitSystem();
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
    }

    private void printWelcomeMessage() {
        //приветствие с названием приложения
        String welcome = """
                     ___   ____    ____  _______      ______     ___       _______     _______.     ___      .______       __    \s
                    /   \\  \\   \\  /   / |   ____|    /      |   /   \\     |   ____|   /       |    /   \\     |   _  \\     |  |   \s
                   /  ^  \\  \\   \\/   /  |  |__      |  ,----'  /  ^  \\    |  |__     |   (----`   /  ^  \\    |  |_)  |    |  |   \s
                  /  /_\\  \\  \\      /   |   __|     |  |      /  /_\\  \\   |   __|     \\   \\      /  /_\\  \\   |      /     |  |   \s
                 /  _____  \\  \\    /    |  |____    |  `----./  _____  \\  |  |____.----)   |    /  _____  \\  |  |\\  \\----.|__|   \s
                /__/     \\__\\  \\__/     |_______|    \\______/__/     \\__\\ |_______|_______/    /__/     \\__\\ | _| `._____|(__)   \s""";

        System.out.println(welcome);

    }

    private void showMainMenu() {

        String firstMessage = "Выберите пункт меню:";
        String positionOne = "Закодировать послание нажмите 1";
        String positionTwo = "Раскодировать послание нажмите 2";
        String positionThree = "Взлом послание перебором нажмите 3";
        String positionFour = "Взлом статистическим анализом текста нажмите 4";
        String positionHelp = "Для справки нажмите 5";
        String positionExit = "Для выхода нажмите 0";
        System.out.println("*".repeat(150));
        System.out.println(firstMessage);
        System.out.println(positionOne);
        System.out.println(positionTwo);
        System.out.println(positionThree);
        System.out.println(positionFour);
        System.out.println(positionExit);
        System.out.println(positionHelp);
    }

    private void processStatisticAnalyzeText() {
        System.out.println("ВЗЛОМ СТАТИСТИЧЕСКИМ АНАЛИЗОМ:");

        try {

            String inputReferenceFile = getInputReferenceFile();
            String inputEncodeFile = getInputEncodeFile();

            String outputFile = getOutputFilePath();
            String contextOne = fileService.readFile(inputReferenceFile);
            String contextTwo = fileService.readFile(inputEncodeFile);

            double[] standardFrequency;
            double[] codeFrequency;

            String response =  getLanguageSelection();

            if (response.equals("R")) {
                System.out.println("Вы, выбрали русский язык");
                standardFrequency = statisticAnalyzeDecoder.calculateSymbolRuss(contextOne);
                codeFrequency = statisticAnalyzeDecoder.calculateSymbolRuss(contextTwo);
            } else {
                System.out.println("Вы, выбрали английский язык");
                standardFrequency = statisticAnalyzeDecoder.calculateSymbolEng(contextOne);
                codeFrequency = statisticAnalyzeDecoder.calculateSymbolEng(contextTwo);
            }
            double[][] allFrequency = statisticAnalyzeDecoder.fillingPossibleOptions(codeFrequency);
            int step = statisticAnalyzeDecoder.compareArrays(allFrequency, standardFrequency);

            String result = caesarCoder.decodeText(contextTwo, step);

            fileService.writeFile(outputFile, result);

        } catch (CaesarException | NumberFormatException e) {
            displayError(e.getMessage());
        }

    }


    private void processEncodeFile() {
        System.out.println("КОДИРОВАНИЕ ФАЙЛА:");
        try {
            String inputFile = getInputFilePath();
            String outputFile = getOutputFilePath();
            int shift = Math.abs(getShiftStep());

            String context = fileService.readFile(inputFile);

            String result = caesarCoder.encodeText(context, shift);

            fileService.writeFile(outputFile, result);

        } catch (CaesarException | NumberFormatException e) {
            displayError(e.getMessage());
        }

    }

    private void processDecodeFile() {
        System.out.println("\n ДЕКОДИРОВАНИЕ ФАЙЛА");

        try {
            String inputFile = getInputFilePath();
            String outputFile = getOutputFilePath();
            int step = Math.abs(getShiftStep());

            String content = fileService.readFile(inputFile);

            String result = caesarCoder.decodeText(content, step);

            fileService.writeFile(outputFile, result);


        } catch (CaesarException | NumberFormatException e) {
            displayError(e.getMessage());
        }


    }

    private void processExitSystem() {
        scanner.close();
        System.out.println("""
                Файлы, необходимые для удаления системы,
                были успешно удалены.
                Удаление Windows 95 теперь будет невозможно!\s""");
        System.exit(0);
    }

    private void processBruteForce() {
        System.out.println("ВЗЛОМ МЕТОДОМ ПЕРЕБОРА \"Brute Force\"");

        try {
            String inputFile = getInputFilePath();
            String outputFile = getOutputFilePath();

            String context = fileService.readFile(inputFile);
            int key = 1;
            String userResponse;
            String result;
            do {

                result = caesarCoder.bruteForce(context, key);
                userResponse = getUserResponse(key);

                if (userResponse.equalsIgnoreCase("N")) {
                    key++;
                }

                if (key > 32) {
                    System.out.println("Пройдены все итерации");
                    break;
                }

            } while (!userResponse.equalsIgnoreCase("Y"));

            if (userResponse.equalsIgnoreCase("Y")) {
                fileService.writeFile(outputFile, result);
            }


        } catch (CaesarException e) {
            displayError(e.getMessage());
        }

    }
    private String getLanguageSelection () {
        System.out.println("Выберите язык закодированного текста.\nАнглийский, нажмите \"E\"\nРусский, нажмите \"R\"");
        String languageSelection = scanner.nextLine();
        return languageSelection.trim().equalsIgnoreCase("E") ? languageSelection.trim() :
                languageSelection.trim().equalsIgnoreCase("R") ? languageSelection.trim() : getLanguageSelection();
    }

    private String getUserResponse(int key) {
        System.out.println("Взлом перебором попытка номер " + key + "\n" +
                "Стал ли текст читаем?");

        System.out.println("Нажмите \"Y\" для подтверждения и записи\nИли \"N\" для следующей итерации");
        String userResponse = scanner.nextLine();
        return userResponse.trim().equalsIgnoreCase("Y") ? userResponse.trim() :
                userResponse.trim().equalsIgnoreCase("N") ? userResponse.trim() : getUserResponse(key);
    }

    private String getInputFilePath() {
        System.out.print("Введите путь к исходному файлу и его имя: ");
        return scanner.nextLine().trim();
    }

    private String getInputReferenceFile() {
        System.out.println("Введите путь файлу содержащий к похожий текст:");
        return scanner.nextLine().trim();
    }

    private String getInputEncodeFile() {
        System.out.println("Введите путь файлу содержащий к закодированный текст:");
        return scanner.nextLine().trim();
    }


    private String getOutputFilePath() {
        System.out.print("Введите путь для результата и имя файла в который запишем результат: ");
        return scanner.nextLine().trim();
    }

    private int getShiftStep() throws NumberFormatException {
        System.out.println("Укажите ключ для кодировки/раскодировки: ");
        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
    }

    private void displayError(String message) {
        System.out.println("\n Ошибка: " + message + "\n"); // вывод сообщения об ошибке
    }

    private void showCaesarInfo() {
        String readMe = "readMe.md";

        try (BufferedReader reader = new BufferedReader(new FileReader(readMe))) {
            fileService.readFile(readMe);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
            }
        } catch (IOException | CaesarException e) {
            displayError(e.getMessage());
        }
    }


    private void startMusic() {
        try {
            URL url = getClass().getResource("/sound/tanksOfDendy.wav");
            try (AudioInputStream ais = AudioSystem.getAudioInputStream(url)) {
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
                Thread.sleep(clip.getMicrosecondLength() / 1000);

                clip.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}








