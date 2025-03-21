package com.quiz.kata_foo_bar_quix.exception;

public class TreatmentException extends RuntimeException {
    public TreatmentException(String message) {
        super("Treatment Exception caused by : "+ message);
    }
}