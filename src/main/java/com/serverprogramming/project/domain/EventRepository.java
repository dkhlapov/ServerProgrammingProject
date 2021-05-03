package com.serverprogramming.project.domain;


import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAllByDate(LocalDate date);
}
