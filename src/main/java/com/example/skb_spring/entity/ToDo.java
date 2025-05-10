package com.example.skb_spring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "to_do")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false) //spring.jpa.hibernate.ddl-auto=update - выставил это, поэтому Column сохранил
    String name;

    @ElementCollection //так как возвращаем только массив строк, решил сэкономить архитектуру, маппинги и не делать доп классы
    @CollectionTable(name = "event", joinColumns = @JoinColumn(name = "to_do_id"))
    @Column(name = "name")
    Set<String> events;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ToDo toDo = (ToDo) object;
        return Objects.equals(id, toDo.id) && Objects.equals(name, toDo.name) && Objects.equals(events, toDo.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, events);
    }
}

