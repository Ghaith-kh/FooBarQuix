package com.quiz.kata_foo_bar_quix.service;

import com.quiz.kata_foo_bar_quix.exception.TreatmentException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
;

class FooBarQuixTransformerTest {

    private FooBarQuixTransformer transformer;

    @BeforeEach
    void setUp() {
        transformer = new FooBarQuixTransformer();
    }

    @Test
    public void should_return_BARBAR_when_input_is_5() {
        Assert.assertEquals("BARBAR", transformer.transform(5));
    }

    @Test
    public void should_return_FOO_when_input_is_3() {
        Assert.assertEquals("FOO", transformer.transform(3));
    }

    @Test
    public void should_return_number_when_no_match() {
        Assert.assertEquals("1", transformer.transform(1));
    }

    @Test
    public void should_return_BARBAR_when_input_contains_5() {
        Assert.assertEquals("BARBAR", transformer.transform(15)); // 15 contient 5
    }

    @Test
    public void should_throw_exception_when_input_is_negative() {
        Assert.assertThrows(TreatmentException.class, () -> transformer.transform(-5));
    }

    @Test
    public void should_throw_exception_when_input_is_null() {
        Assert.assertThrows(IllegalArgumentException.class, () -> transformer.transform(null));
    }



}
