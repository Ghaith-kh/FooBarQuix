package com.quiz.kata_foo_bar_quix.controllers;

import com.quiz.kata_foo_bar_quix.batch.BatchLauncher;
import com.quiz.kata_foo_bar_quix.exception.GlobalExceptionHandler;
import com.quiz.kata_foo_bar_quix.service.IFooBarQuixService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = FooBarQuixController.class)
@Import(GlobalExceptionHandler.class) // ✅ Ajoute l'ExceptionHandler
@AutoConfigureMockMvc(addFilters = false) // ✅ Désactive la sécurité pour les tests
class FooBarQuixControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IFooBarQuixService fooBarQuixService;

    @MockitoBean
    private BatchLauncher batchLauncher;

    @Test
    void should_return_transformed_value_when_input_is_valid() throws Exception {
        Mockito.when(fooBarQuixService.transform(3)).thenReturn("FOO");

        mockMvc.perform(get("/api/conversion/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("FOO"));
    }

    @Test
    void should_return_bad_request_when_input_is_not_a_number() throws Exception {
        mockMvc.perform(get("/api/conversion/abc"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid input: 'abc' is not a valid number."));
    }

    @Test
    void should_return_500_when_unexpected_error_occurs() throws Exception {
        Mockito.when(fooBarQuixService.transform(Mockito.anyInt())).thenThrow(new RuntimeException("Unexpected Error"));

        mockMvc.perform(get("/api/conversion/99"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("An unexpected error occurred: Unexpected Error"));
    }
}
