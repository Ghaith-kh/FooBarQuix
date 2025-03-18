package com.quiz.kata_foo_bar_quix.service;

import org.springframework.stereotype.Service;

@Service
public class FooBarQuixService implements IFooBarQuixService  {
    public String transform(int number) {
        return FooBarQuixTransformer.transform(number);
    }
}
