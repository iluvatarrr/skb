package com.example.skb_spring.service;

import com.example.skb_spring.dto.ToDoDto;
import com.example.skb_spring.entity.ToDo;
import com.example.skb_spring.repository.ToDoRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ToDoService {

    ToDoRepository toDoRepository;

    @Transactional(readOnly = true)
    public List<ToDoDto> findAll() {
        return toDoRepository.findAllWithEvents().stream().map(this::toDto)
                .toList();
    }

    public void save(ToDoDto toDoDto) {
        toDoRepository.save(toModel(toDoDto));
    }

    private ToDo toModel(ToDoDto toDoDto) {
        return ToDo.builder().name(toDoDto.name()).events(toDoDto.events()).build();
    }

    private ToDoDto toDto(ToDo toDo) {
        return new ToDoDto(toDo.getName(),toDo.getEvents());
    }
}
