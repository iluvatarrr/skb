package com.example.skb_spring.service;

import com.example.skb_spring.dto.WorkerDto;
import com.example.skb_spring.model.Worker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkerService {

    public void add(WorkerDto workerDto) {
        var worker = mapToModel(workerDto);
        log.info("Add worker : {}", worker.getName());
    }

    public Worker mapToModel(WorkerDto workerDto) {
        return new Worker(workerDto.name(), workerDto.age(), workerDto.experienceYears());
    }
}
