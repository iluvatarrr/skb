package com.example.skb_spring.controller;

import com.example.skb_spring.dto.WorkerDto;
import com.example.skb_spring.service.WorkerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@Validated
public class ValidTaskController {

    private final WorkerService workerService;
//        для проверки
//        {
//            "name": "Иван Иванов",
//             "age": 30,
//             "experienceYears": 22
//        }
    @PostMapping("/validation")
    public void addWorker(@RequestBody @Valid WorkerDto workerDto) {
        workerService.add(workerDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
