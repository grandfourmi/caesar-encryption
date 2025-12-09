package com.javarush;
import com.javarush.core.CaesarCoder;
import com.javarush.exception.CaesarException;
import com.javarush.model.ProcessingResult;
import com.javarush.service.FileService;
import javax.sound.sampled.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class CaesarApp {

    private final Scanner scanner;
    private final FileService fileService ; //  поля класса - зависимости
    private final CaesarCoder caesarCoder;

    public CaesarApp() {
        this.scanner = new Scanner(System.in);
        this.fileService = new FileService();
        this.caesarCoder = new CaesarCoder();
    }

    // конструктор - инициализация зависимостей


     static void main() {
        //создать экземпляр приложения и запустить
        CaesarApp  app = new CaesarApp();
        app.run();

    }

    public void run(){

        printWelcomeMessage(); //1. Вывести приложение
        //startMusic();

        while (true){ //2. Меню (бесконечный цикл)

            showMainMenu();
            System.out.println("Сделайте выбор: ");
            String input = scanner.nextLine();

            switch (input){
                case "1":
                    processEncodeFile();
                    break;
                case "2":
                    processDecodeFile();
                    break;
                case "3":
                    showCaesarInfo();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
            // if (input.equalsIgnoreCase("EXIT")){break;} 4. выход по команде

//            if (input.equalsIgnoreCase("HELP")) {
//                showCaesarInfo();
//                continue;
//            }



//            if (inputInt == 1 || inputInt == 2){
//                System.out.println(inputInt == 1 ? "ШИФРОВАНЕ" : "ДЕШИФРОВКА");
//
//                getInputFilePath();
//
//                String source = scanner.nextLine();
//
//                getOutputFilePath();
//
//                String target = scanner.nextLine();
//
//                System.out.println("Укажите сдвиг");
//
//                int step = scanner.nextInt();
//
//
//
//                if (inputInt == 1) {
//
//                    processEncodeFile(source, target, step);
//
//                } else {
//
//                    processDecodeFile(source,target, step);
//                }
//
//
//            }else if (inputInt == 3) {
//
//                //getInputFilePath();
//                //getOutputFilePath();
//
//                System.out.println("В разработке");
//            } else if (inputInt == 4) {
//
//                //getInputFilePath();
//                //getOutputFilePath();
//
//                System.out.println("В разработке");
//            } else {
//                System.out.println("От I до IV");
//            }
        }

    }

    private void printWelcomeMessage(){
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

    private void showMainMenu(){
        //отобразить меню с вариантами действий
        //String stars = "*******************";
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

    private void processEncodeFile() {
        // обработка кодирования файла
        System.out.println("Кодирование файла:");
        try {
            String inputFile = getInputFilePath();
            String outputFile = getOutputFilePath();

            String context = fileService.readFile(inputFile);

            ProcessingResult result = caesarCoder.encodeText(context);

            fileService.writeFile(result.getOutputPreview(), outputFile);

            displaySuccessResult(result, inputFile, outputFile);
        } catch (CaesarException e) {
            displayError(e.getMessage());
        }


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

//        displaySuccessResult(); //5. Дать обратную связь

    }

    private void processDecodeFile(){
        // обработка декодирования файла

        System.out.println("\n ДЕКОДИРОВАНИЕ ФАЙЛА");

        try {
            String inputFile = getInputFilePath();
            String outputFile = getOutputFilePath();

            String content = fileService.readFile(inputFile);
            ProcessingResult result = caesarCoder.decodeText(content);
            fileService.writeFile(result.getOutputPreview(), outputFile);

            displaySuccessResult(result, inputFile, outputFile);

        } catch (CaesarException e) {
            displayError(e.getMessage());
        }


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

//        displaySuccessResult(); // 4 показать успешное завершение

    }

    private String getInputFilePath() {
        System.out.print("Введите путь к исходному файлу (с кодом Морзе) и его имя: ");
        return scanner.nextLine().trim();
    }


    private String getOutputFilePath() {
        System.out.print("Введите путь для результата и имя файла в который запишем результат: ");
        return scanner.nextLine().trim();
    }

    private void displaySuccessResult(ProcessingResult result, String inputFile, String outputFile) {
        // красивый вывод успешного результата
        System.out.println("\n " + result.getMessage());
        System.out.println("Исходный файл: " + inputFile);
        System.out.println("Результат: " + outputFile);

        System.out.println("\nПревью:");
        System.out.println("Вход: " + result.getInputPreview());
        System.out.println("Выход: " + result.getOutputPreview());
    }

    private void displayError(String message) {
        System.out.println("\n Ошибка: " + message + "\n"); // вывод сообщения об ошибке
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




