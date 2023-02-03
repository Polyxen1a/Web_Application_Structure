package com.skypro.maven.controller;


import com.skypro.maven.model.Ingredient;
import com.skypro.maven.service.IngredientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ingredient")
@RequiredArgsConstructor

public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping("{/id}")
    Ingredient getIngredient(@PathVariable Integer id) {
        return ingredientService.getIngredient(id);

    }

    @PostMapping
    Ingredient addIngredient(@Valid @RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient((ingredient));

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;

    };
}
