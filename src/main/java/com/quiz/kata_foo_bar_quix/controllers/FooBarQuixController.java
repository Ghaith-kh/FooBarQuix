package com.quiz.kata_foo_bar_quix.controllers;

import com.quiz.kata_foo_bar_quix.service.IFooBarQuixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversion")
public class FooBarQuixController {
    private static final Logger logger = LoggerFactory.getLogger(FooBarQuixController.class);
    private final IFooBarQuixService fooBarQuixService;

    public FooBarQuixController(IFooBarQuixService fooBarQuixService) {
        this.fooBarQuixService = fooBarQuixService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<String> convertNumber(@PathVariable String number) {
        logger.info("📥 Requête reçue pour convertir : {}", number);

        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            logger.error("🚨 Erreur : L'entrée '{}' n'est pas un nombre valide.", number);
            throw new IllegalArgumentException("Invalid input: '" + number + "' is not a valid number.");
        }

        String result = fooBarQuixService.transform(num);
        logger.info(" Conversion réussie : {} -> {}", number, result);
        return ResponseEntity.ok(result);
    }
}
