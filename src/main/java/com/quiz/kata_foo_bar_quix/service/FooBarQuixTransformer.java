package com.quiz.kata_foo_bar_quix.service;

public class FooBarQuixTransformer {
    private FooBarQuixTransformer() {
        // Constructeur privé pour empêcher l'instanciation
    }

    public static String transform(int number) {
        StringBuilder result = new StringBuilder();

        applyDivisibilityRules(number, result);
        applyDigitRules(number, result);

        return result.length() > 0 ? result.toString() : String.valueOf(number);
    }

    private static void applyDivisibilityRules(int number, StringBuilder result) {
        if (number % 3 == 0) result.append("FOO");
        if (number % 5 == 0) result.append("BAR");
    }

    private static void applyDigitRules(int number, StringBuilder result) {
        for (char digit : String.valueOf(number).toCharArray()) {
            switch (digit) {
                case '3' -> result.append("FOO");
                case '5' -> result.append("BAR");
                case '7' -> result.append("QUIX");
            }
        }
    }

}
