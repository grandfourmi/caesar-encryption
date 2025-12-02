caesar
    CaesarApp               //Точка входа
    core
        CaesarCoder         //Бизнес логика
        [CaesarCoder.java](src/main/java/com/javarush/core/CaesarCoder.java)
        mayBe Alphabet      //Константы
        [Alphabet.java](src/main/java/com/javarush/core/Alphabet.java);
    service
        File Service        //Работа с файлами
        [FileService.java](src/main/java/com/javarush/service/FileService.java)
        ValidationService   //Валидация
        [ValidationService.java](src/main/java/com/javarush/service/ValidationService.java)
    model
        ProcessingResult    //Модель данных
        [ProcessingResult.java](src/main/java/com/javarush/ProcessingResult.java)
    exceptions
        CaesarException
        [CaesarException.java](src/main/java/com/javarush/exception/CaesarException.java)
        FilleProcessingException
