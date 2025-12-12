package com.javarush.core;

public class StatisticAnalyzeDecoder {

    public double[] calculateSymbolRuss(String text) {

        final String RUS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        final int LENGTH_RUSS = RUS.length();

        int[] symbolsCount = new int[LENGTH_RUSS];
        long count = 0;

        for (char ch : text.toCharArray()) {
            ch = Character.toLowerCase(ch);

            int index = RUS.indexOf(ch);
            if (index != -1) {
                symbolsCount[index]++;
                count++;
            }
        }

        double[] symbolsFrequency = new double[LENGTH_RUSS];
        for (int i = 0; i < LENGTH_RUSS; i++) {
            symbolsFrequency[i] = (double) symbolsCount[i] / count;
        }

        return symbolsFrequency;
    }

    public double[] calculateSymbolEng(String text) {
        final String ENG = "abcdefghijklmnopqrstuvwxyz";
        final int LENGTH_ENG = ENG.length();

        int[] symbolsCount = new int[LENGTH_ENG];
        long count = 0;

        for (char ch : text.toCharArray()) {
            ch = Character.toLowerCase(ch);

            int index = ENG.indexOf(ch);
            if (index != -1) {
                symbolsCount[index]++;
                count++;
            }
        }

        double[] symbolsFrequency = new double[symbolsCount.length];
        for (int i = 0; i < symbolsCount.length; i++) {
            symbolsFrequency[i] = (double) symbolsCount[i] / count;
        }
        return symbolsFrequency;

    }

    public double[][] fillingPossibleOptions(double[] symbolsFrequency) {

        int n = symbolsFrequency.length;

        double[][] allFrequency = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                allFrequency[i][j] = symbolsFrequency[(j + i) % n]; // сдвиг с циклическим модулем
            }
        }
        return allFrequency;
    }

    public int compareArrays(double[][] allFrequency, double[] standardFrequency) {
        int n = standardFrequency.length;
        double[] squareX = new double[n];

        for (int i = 0; i < n; i++) {
            double frequencyDeviations = 0.0;

            for (int j = 0; j < n; j++) {
                double observed = allFrequency[i][j];
                double expected = standardFrequency[j];
                frequencyDeviations += Math.pow(observed - expected, 2) / expected;
            }

            squareX[i] = frequencyDeviations;
        }

        int bestKey = 0;
        double minDiff = squareX[0];

        for (int i = 1; i < n; i++) {
            if (squareX[i] < minDiff) {
                minDiff = squareX[i];
                bestKey = i;
            }
        }

        return bestKey;
    }
}







