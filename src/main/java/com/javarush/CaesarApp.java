package com.javarush;
import com.javarush.exception.CaesarException;
import com.javarush.service.FileService;
import javax.sound.sampled.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class CaesarApp {

    Scanner scanner;
    FileService fileService = new FileService();//  поля класса - зависимости

    public CaesarApp() {}   // конструктор - инициализация зависимостей


    static void main() {
        //создать экземпляр приложения и запустить
        CaesarApp  app = new CaesarApp();
        app.run();

    }

    public void run(){
        // реализовать главный цикл приложения
        printWelcomeMessage(); //1. Вывести приложение
        //startMusic();
        int inputInt = 0;

        while (true){ //2. Меню (бесконечный цикл)
            showMainMenu();
            scanner = new Scanner(System.in);

            System.out.println("Сделайте выбор: ");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("EXIT")){break;} //4. выход по команде

            if (input.equalsIgnoreCase("HELP")) {
                showCaesarInfo();
                continue;
            }
            try {
                inputInt = Integer.parseInt(input);

            }  catch (NumberFormatException e) {
                new CaesarException("Не правильный ввод!!!");
            }


            if (inputInt == 1 || inputInt == 2){
                System.out.println(inputInt == 1 ? "ШИФРОВАНЕ" : "ДЕШИФРОВКА");

                getInputFilePath();

                String source = scanner.nextLine();

                getOutputFilePath();

                String target = scanner.nextLine();

                System.out.println("Укажите сдвиг");

                int step = scanner.nextInt();



                if (inputInt == 1) {

                    processEncodeFile(source, target, step);

                } else {

                    processDecodeFile(source,target, step);
                }


            }else if (inputInt == 3) {

                //getInputFilePath();
                //getOutputFilePath();

                System.out.println("В разработке");
            } else if (inputInt == 4) {

                //getInputFilePath();
                //getOutputFilePath();

                System.out.println("В разработке");
            } else {
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
        String stars = "*******************";
        String firstMessage = "Идущие на смерть приветствуют тебя \nвыберите пункт меню:";
        String positionOne =   "I.  Закодировать послание";
        String positionTwo =   "II. Раскодировать послание";
        String positionThree = "III. Взлом послание перебором";
        String positionFour =  "IV. Взлом статическим анализом";
        String positionExit =  "Для выхода нажмите EXIT";
        String positionHelp =  "Для справки введите HELP";
        System.out.println(firstMessage);
        System.out.println(positionOne);
        System.out.println(positionTwo);
        System.out.println(positionThree);
        System.out.println(positionFour);
        System.out.println(positionExit);
        System.out.println(positionHelp);
        }

    private void processEncodeFile(String source, String destination, int step) {
        // обработка кодирования файла

        if (!fileService.isFilesExists(source)) displayErrorResult();

//        try {
//            fileService.readFile(source); //2. прочитать исходный файл
//        } catch (CaesarException e) {
//            throw new RuntimeException(e);
//        }
//
//        //3. закодировать текст
//
//        try {
//            fileService.writeFile(destination,""); //4. записать результат
//        } catch (CaesarException e) {
//            throw new RuntimeException(e);
//        }

        displaySuccessResult(); //5. Дать обратную связь

    }

    private void processDecodeFile(String source, String destination, int step){
        // обработка декодирования файла
        if (!fileService.isFilesExists(source)) displayErrorResult();

//        try {
//            fileService.readFile(source); // 2 прочитать файл
//        } catch (CaesarException e) {
//            throw new RuntimeException(e);
//        }
//
//        // 3 декодировать цезаря
//
//        try {
//            fileService.writeFile(destination,"");
//        } catch (CaesarException e) {
//            throw new RuntimeException(e);
//        }

        displaySuccessResult(); // 4 показать успешное завершение

    }

    private void getInputFilePath(){
        System.out.println("Укажите путь файла для чтения");// запрос пути к исходному файлу
    }

    private void getOutputFilePath(){
        System.out.println("Укажите путь файла для записи"); // запрос пути для записи результата

    }

    private void displaySuccessResult() {
        // красивый вывод успешного результата
    }

    private void displayErrorResult() {
        System.out.println("Проверьте путь файла и попробуйте еще раз"); // вывод сообщения об ошибке
    }

    private void showCaesarInfo () {
        System.out.println("Какая то справка");
    }

    private void startMusic () {
        // Полностью украденный код в функционале не разбирался

        try {
                    Path sound = Path.of("C:\\JavaProject\\CaesarCodding\\caesar-codding\\src\\sound\\tanksOfDendy.wav");
                    //Получаем AudioInputStream
                    //Вот тут могут полететь IOException и UnsupportedAudioFileException
                    AudioInputStream ais = AudioSystem.getAudioInputStream(sound.toFile());

                    //Получаем реализацию интерфейса Clip
                    // может выкинуть LineUnavailableException
                    Clip clip = AudioSystem.getClip();

                    //Загружаем наш звуковой поток в Clip
                    // может выкинуть IOException и LineUnavailableException
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




