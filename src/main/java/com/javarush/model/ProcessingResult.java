package com.javarush.model;

public class ProcessingResult {

    private  final  boolean success; //  успешное выполнение
    private  final  String message; // сообщение для пользователя
     private final String inputPreview; // что на входе
    private  final String outputPreview; // что на выходе

    public ProcessingResult(boolean success, String message, String inputPreview, String outputPreview) {
        this.success = success;
        this.message = message;
        this.inputPreview = inputPreview;
        this.outputPreview = outputPreview;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getInputPreview() {
        return inputPreview;
    }

    public String getOutputPreview() {
        return outputPreview;
    }

    @Override
    public String toString() {
        return "ProcessingResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", inputPreview='" + inputPreview + '\'' +
                ", outputPreview='" + outputPreview + '\'' +
                '}';
    }
}

