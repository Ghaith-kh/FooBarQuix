package com.quiz.kata_foo_bar_quix.controllers;

import com.quiz.kata_foo_bar_quix.service.IFooBarQuixService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversion")
public class FooBarQuixController {
    private final IFooBarQuixService fooBarQuixService;

    public FooBarQuixController(IFooBarQuixService fooBarQuixService) {
        this.fooBarQuixService = fooBarQuixService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<String> convertNumber(@PathVariable String number) {
        try {
            int num = Integer.parseInt(number);
            String result = fooBarQuixService.transform(num);
            return ResponseEntity.ok(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: '" + number + "' is not a valid number.");
        }
    }
}
