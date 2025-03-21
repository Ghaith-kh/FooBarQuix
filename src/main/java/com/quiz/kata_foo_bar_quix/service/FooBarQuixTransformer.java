package com.quiz.kata_foo_bar_quix.service;

import com.quiz.kata_foo_bar_quix.exception.TreatmentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FooBarQuixTransformer {
    private static final Logger logger = LoggerFactory.getLogger(FooBarQuixTransformer.class);

    FooBarQuixTransformer() {
        // Constructeur privé pour empêcher l'instanciation
    }

    public static String transform(Integer number) {
        try {
            StringBuilder result = new StringBuilder();

            applyDivisibilityRules(number, result);
            applyDigitRules(number, result);

            return result.length() > 0 ? result.toString() : String.valueOf(number);
        } catch (TreatmentException e) {
            logger.error("Error transforming number: {} - {}", number, e.getMessage(), e);
            throw new TreatmentException(e.getMessage());
        }
    }

    private static void applyDivisibilityRules(int number, StringBuilder result) {
        try {
            if (number % 3 == 0) result.append("FOO");
            if (number % 5 == 0) result.append("BAR");
        } catch (TreatmentException e) {
            logger.error("Arithmetic error while checking divisibility of: {}", number, e);
            throw new TreatmentException(e.getMessage());
        }
    }

    private static void applyDigitRules(int number, StringBuilder result) {
        try {
            for (char digit : String.valueOf(number).toCharArray()) {
                switch (digit) {
                    case '3' -> result.append("FOO");
                    case '5' -> result.append("BAR");
                    case '7' -> result.append("QUIX");
                }
            }
        } catch (Exception e) {
            logger.error("Error processing digits of number: {}", number, e);
            throw new TreatmentException(e.getMessage());

        }
    }
}
