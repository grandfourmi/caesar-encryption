package com.javarush;


import com.javarush.exception.CaesarException;

import javax.sound.sampled.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class CaesarApp {

    //  поля класса - зависимости

    Scanner scanner;


    // конструктор - инициализация зависимостей

    public CaesarApp() {

        scanner = new Scanner(System.in);
    }

    public static void main() {
        //создать экземпляр приложения и запустить
        CaesarApp  app = new CaesarApp();
        app.run();
    }

    public void run(){
        // реализовать главный цикл приложения
        final String EXIT = "EXIT";



        printWelcomeMessage(); //1. Вывести приложение
        showMainMenu();
        startMusic();
        while (scanner.hasNextLine()){ //2. Меню (бесконечный цикл)
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase(EXIT)){break;} //4. выход по команде

            int inputInt = 0;

            try {
                inputInt = Integer.parseInt(input);

            }  catch (NumberFormatException e) {
                new CaesarException("Не правильный ввод!!!");
            }

            switch (inputInt) {        //3. Обработка выбора пользователя
                case 1:
                break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("От I до IV");
            }

        }

    }

    private void printWelcomeMessage(){
        //приветствие с названием приложения
        String welcome = "     ___   ____    ____  _______      ______     ___       _______     _______.     ___      .______       __     \n" +
                "    /   \\  \\   \\  /   / |   ____|    /      |   /   \\     |   ____|   /       |    /   \\     |   _  \\     |  |    \n" +
                "   /  ^  \\  \\   \\/   /  |  |__      |  ,----'  /  ^  \\    |  |__     |   (----`   /  ^  \\    |  |_)  |    |  |    \n" +
                "  /  /_\\  \\  \\      /   |   __|     |  |      /  /_\\  \\   |   __|     \\   \\      /  /_\\  \\   |      /     |  |    \n" +
                " /  _____  \\  \\    /    |  |____    |  `----./  _____  \\  |  |____.----)   |    /  _____  \\  |  |\\  \\----.|__|    \n" +
                "/__/     \\__\\  \\__/     |_______|    \\______/__/     \\__\\ |_______|_______/    /__/     \\__\\ | _| `._____|(__)    ";

        System.out.println(welcome);

    }

    private void showMainMenu(){
        //отобразить меню с вариантами действий
        String firstMessage = "Идущие на смерть приветствуют тебя \nвыберите пункт меню:";
        String positionOne =   "I.  Закодировать послание";
        String positionTwo =   "II. Раскодировать послание";
        String positionThree = "III. Взлом послание перебором";
        String positionFour =  "IV. Взлом статическим анализом";
        String positionExit =  "Для выхода нажмите EXIT";
        System.out.println(firstMessage);
        System.out.println(positionOne);
        System.out.println(positionTwo);
        System.out.println(positionThree);
        System.out.println(positionFour);
        System.out.println(positionExit);
        }

    private void processEncodeFile(){
        // обработка кодирования файла
        //1. получить пути файлов
        //2. прочитать исходный файл
        //3. закодировать текст
        //4. записать результат
        //5. Дать обратную связь

    }

    private void processDecodeFile(){
        // обработка декодирования файла
        // 1 получить пути
        // 2 прочитать файл
        // 3 декодировать цезаря
        // 4 показать успешное завершение
    }

    private String getInputFilePath(){
        // запрос пути к исходному файлу
        return null;
    }

    private String getOutputFilePath(){
        // запрос пути для записи результата
        return null;
    }

    private void displaySuccessResault() {
        // красивый вывод успешного результата
    }

    private void displayErrorResault(String message) {
        // ввывод сообщения об ошибке
    }

    private void showAlphaberInfo () {

        // вывод справки по алфавиту Морзе
    }

    private void startMusic () {
        // Полностью украденный код в функционале не разбирался

        try {
                    Path sound = Path.of("C:\\JavaProject\\CaesarCodding\\caesar-codding\\src\\sound\\tanksOfDendy.wav");
                    //Получаем AudioInputStream
                    //Вот тут могут полететь IOException и UnsupportedAudioFileException
                    AudioInputStream ais = AudioSystem.getAudioInputStream(sound.toFile());

                    //Получаем реализацию интерфейса Clip
                    //Может выкинуть LineUnavailableException
                    Clip clip = AudioSystem.getClip();

                    //Загружаем наш звуковой поток в Clip
                    //Может выкинуть IOException и LineUnavailableException
                    clip.open(ais);

                    clip.setFramePosition(0); //устанавливаем указатель на старт
                    clip.start(); //Поехали!!!

                    //Если не запущено других потоков, то стоит подождать, пока клип не закончится
                    //В GUI-приложениях следующие 3 строчки не понадобятся
                    Thread.sleep(clip.getMicrosecondLength()/1000);
                    // clip.stop(); //Останавливаем
                    clip.close(); //Закрываем
                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc ) {
                    exc.printStackTrace();
                } catch (InterruptedException _) {}
            }
}




