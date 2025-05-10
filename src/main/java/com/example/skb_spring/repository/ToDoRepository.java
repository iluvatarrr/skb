package com.example.skb_spring.repository;

import com.example.skb_spring.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

    @Query("SELECT t FROM ToDo t LEFT JOIN FETCH t.events")
    Set<ToDo> findAllWithEvents();

}
