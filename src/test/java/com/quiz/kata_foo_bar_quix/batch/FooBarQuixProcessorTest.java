package com.quiz.kata_foo_bar_quix.batch;

import com.quiz.kata_foo_bar_quix.exception.ProcessorException;
import com.quiz.kata_foo_bar_quix.service.IFooBarQuixService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class FooBarQuixProcessorTest {

    private FooBarQuixProcessor processor;
    private IFooBarQuixService fooBarQuixService;

    @BeforeEach
    void setUp() {
        fooBarQuixService = Mockito.mock(IFooBarQuixService.class);
        processor = new FooBarQuixProcessor(fooBarQuixService);
    }

    @Test
    void should_transform_valid_number() {
        Mockito.when(fooBarQuixService.transform(3)).thenReturn("FOO");

        String result = processor.process("3");
        assertEquals("3 -> FOO", result);
    }

    @Test
    void should_throw_exception_when_input_is_not_a_number() {
        ProcessorException exception = assertThrows(ProcessorException.class, () -> processor.process("abc"));
        assertEquals("Invalid input: abc", exception.getMessage());
    }

    @Test
    void should_throw_exception_when_input_is_empty() {
        ProcessorException exception = assertThrows(ProcessorException.class, () -> processor.process("   "));
        assertEquals("Invalid input: empty or null value", exception.getMessage());
    }

    @Test
    void should_throw_exception_when_input_is_null() {
        ProcessorException exception = assertThrows(ProcessorException.class, () -> processor.process(null));
        assertEquals("Invalid input: empty or null value", exception.getMessage());
    }
}