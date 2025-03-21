package com.quiz.kata_foo_bar_quix.batch;

import com.quiz.kata_foo_bar_quix.exception.ProcessorException;
import com.quiz.kata_foo_bar_quix.service.IFooBarQuixService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class FooBarQuixProcessor implements ItemProcessor<String, String> {

    private static final Logger logger = LoggerFactory.getLogger(FooBarQuixProcessor.class);
    private final IFooBarQuixService fooBarQuixService;

    public FooBarQuixProcessor(IFooBarQuixService fooBarQuixService) {
        this.fooBarQuixService = fooBarQuixService;
    }

    @Override
    public String process(String item) throws ProcessorException {
        if (item == null || item.trim().isEmpty()) {
            logger.error("🚨 Erreur : L'entrée est vide ou nulle.");
            throw new ProcessorException("Invalid input: empty or null value");
        }

        try {
            int number = Integer.parseInt(item.trim());
            String result = number + " -> " + fooBarQuixService.transform(number);
            logger.info("✅ Processed: {} -> {}", number, result);
            return result;
        } catch (NumberFormatException e) {
            logger.error("🚨 Erreur : L'entrée '{}' n'est pas un nombre valide.", item);
            throw new ProcessorException("Invalid input: " + item, e);
        }
    }
}
