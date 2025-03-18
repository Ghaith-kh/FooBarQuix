package com.quiz.kata_foo_bar_quix.service;

import org.junit.Assert;
import org.junit.Test;
;

class FooBarQuixTransformerTest {

    @Test
    void testTransform() {
        Assert.assertEquals("FOOFOO", FooBarQuixTransformer.transform(3));
        Assert.assertEquals("BARBAR", FooBarQuixTransformer.transform(5));
        Assert.assertEquals("QUIX", FooBarQuixTransformer.transform(7));
        Assert.assertEquals("FOOBAR", FooBarQuixTransformer.transform(51));
        Assert.assertEquals("BARFOO", FooBarQuixTransformer.transform(53));
        Assert.assertEquals("FOOFOOFOO", FooBarQuixTransformer.transform(33));
        Assert.assertEquals("FOOBARBAR", FooBarQuixTransformer.transform(15));
        Assert.assertEquals("1", FooBarQuixTransformer.transform(1));
    }
}
