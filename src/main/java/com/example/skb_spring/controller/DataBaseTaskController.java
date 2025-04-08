package com.example.skb_spring.controller;

import com.example.skb_spring.dto.ToDoDto;
import com.example.skb_spring.service.ToDoService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/toDo")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DataBaseTaskController {

    ToDoService toDoService;

    @GetMapping
    public List<ToDoDto> findAll() {
        return toDoService.findAll();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody ToDoDto toDoDto) {
        toDoService.save(toDoDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
