package com.example.skb_spring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "to_do")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @ElementCollection //так как возвращаем только массив строк, решил сэкономить архитектуру, маппинги и не делать доп классы
    @CollectionTable(name = "event", joinColumns = @JoinColumn(name = "to_do_id"))
    @Column(name = "name")
    Set<String> events = new HashSet<>();
}

