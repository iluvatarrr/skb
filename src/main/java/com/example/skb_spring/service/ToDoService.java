package com.example.skb_spring.service;

import com.example.skb_spring.dto.ToDoDto;
import com.example.skb_spring.entity.ToDo;
import com.example.skb_spring.repository.ToDoRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ToDoService {

    ModelMapper modelMapper;
    ToDoRepository toDoRepository;

    @Transactional(readOnly = true)
    public List<ToDoDto> findAll() {
        return toDoRepository.findAll().stream().map(this::toDto)
                .toList();
    }

    public void save(ToDoDto toDoDto) {
        toDoRepository.save(toModel(toDoDto));
    }

    private ToDo toModel(ToDoDto toDoDto) {
        return modelMapper.map(toDoDto, ToDo.class);
    }

    private ToDoDto toDto(ToDo toDo) {
        return modelMapper.map(toDo, ToDoDto.class);
    }
}
