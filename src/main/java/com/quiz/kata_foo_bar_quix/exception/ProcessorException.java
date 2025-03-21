package com.quiz.kata_foo_bar_quix.exception;

public class ProcessorException extends RuntimeException {
    public ProcessorException(String message) {
        super(message);
    }

    public ProcessorException(String message, Throwable cause) {
        super(message, cause);
    }
}