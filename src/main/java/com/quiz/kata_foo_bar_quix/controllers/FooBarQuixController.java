package com.quiz.kata_foo_bar_quix.controllers;

import com.quiz.kata_foo_bar_quix.service.IFooBarQuixService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversion")
public class FooBarQuixController {
    private final IFooBarQuixService fooBarQuixService;

    public FooBarQuixController(IFooBarQuixService fooBarQuixService) {
        this.fooBarQuixService = fooBarQuixService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<String> convertNumber(@PathVariable int number) {
        return ResponseEntity.ok(fooBarQuixService.transform(number));
    }
}
