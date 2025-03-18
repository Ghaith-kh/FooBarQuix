package com.quiz.kata_foo_bar_quix.batch;

import com.quiz.kata_foo_bar_quix.service.IFooBarQuixService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component

public class FooBarQuixProcessor implements ItemProcessor<String, String> {

    private final IFooBarQuixService fooBarQuixService;

    public FooBarQuixProcessor(IFooBarQuixService fooBarQuixService) {
        this.fooBarQuixService = fooBarQuixService;
    }

    @Override
    public String process(String item) {
        try {
            int number = Integer.parseInt(item.trim());
            return number + " -> " + fooBarQuixService.transform(number);
        } catch (NumberFormatException e) {
            return "Invalid input: " + item;
        }
    }
}