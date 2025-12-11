package com.javarush;
import com.javarush.core.CaesarCoder;
import com.javarush.exception.CaesarException;
import com.javarush.service.FileService;
import javax.sound.sampled.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;


// C:\JavaProject\CaesarCodding\caesar-codding\src\text\Gaar.txt
// C:\JavaProject\CaesarCodding\caesar-codding\src\text\encodedText.txt
public class CaesarApp {

    private final Scanner scanner;
    private final FileService fileService ; //  поля класса - зависимости
    private final CaesarCoder caesarCoder;

    public CaesarApp() {
        this.scanner = new Scanner(System.in);
        this.fileService = new FileService();
        this.caesarCoder = new CaesarCoder();
    }


     static void main() {
        CaesarApp  app = new CaesarApp();
        app.run();

    }

    public void run(){

        printWelcomeMessage();
        //startMusic();

        while (true){

            showMainMenu();
            String input = scanner.nextLine();

            switch (input){
                case "1":
                    processEncodeFile();
                    break;
                case "2":
                    processDecodeFile();
                    break;
                case "3":
                    System.out.println("В разработке");
                    break;
                case "5":
                    showCaesarInfo();
                    break;
                case "0":
                    System.out.println("""
                            Файлы, необходимые для удаления системы,
                            были успешно удалены.
                            Удаление Windows 95 теперь будет невозможно!\s""");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
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

        String firstMessage = "Выберите пункт меню:";
        String positionOne =   "Закодировать послание нажмите 1";
        String positionTwo =   "Раскодировать послание нажмите 2";
        String positionThree = "Взлом послание перебором нажмите 3";
        String positionHelp =  "Для справки нажмите 5";
        String positionExit =  "Для выхода нажмите 0";
        System.out.println("*".repeat(positionOne.length()));
        System.out.println(firstMessage);
        System.out.println(positionOne);
        System.out.println(positionTwo);
        System.out.println(positionThree);
        System.out.println(positionExit);
        System.out.println(positionHelp);
        }

    private void processEncodeFile() {
        // обработка кодирования файла
        System.out.println("КОДИРОВАНИЕ ФАЙЛА:");
        try {
            String inputFile = getInputFilePath();
            String outputFile = getOutputFilePath();
            int shift = getShiftStep();

            String context = fileService.readFile(inputFile);

            String result = caesarCoder.encodeText( context, shift );

            fileService.writeFile(outputFile,result);

        } catch (CaesarException  | NumberFormatException e) {
            displayError(e.getMessage());
        }

    }

    private void processDecodeFile(){
        // обработка декодирования файла

        System.out.println("\n ДЕКОДИРОВАНИЕ ФАЙЛА");

        try {
            String inputFile = getInputFilePath();
            String outputFile = getOutputFilePath();
            int shift = getShiftStep();

            String content = fileService.readFile(inputFile);

            String result = caesarCoder.decodeText(content, shift);

            fileService.writeFile( outputFile, result);

        //    displaySuccessResult(result, inputFile, outputFile);

        } catch (CaesarException  | NumberFormatException e) {
            displayError(e.getMessage());
        }


    }

    private String getInputFilePath() {
        System.out.print("Введите путь к исходному файлу и его имя: ");
        return scanner.nextLine().trim();
    }


    private String getOutputFilePath() {
        System.out.print("Введите путь для результата и имя файла в который запишем результат: ");
        return scanner.nextLine().trim();
    }

    private int getShiftStep  () throws NumberFormatException {
        System.out.println("Укажите ключ для кодировки/раскодировки: ");
        String input = scanner.nextLine().trim();
            return Integer.parseInt(input);
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





