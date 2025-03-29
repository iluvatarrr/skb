package com.example.skb_spring.controller;

import com.example.skb_spring.dto.WorkerDto;
import com.example.skb_spring.service.WorkerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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

}
