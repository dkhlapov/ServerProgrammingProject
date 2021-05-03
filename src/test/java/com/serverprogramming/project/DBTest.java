package com.serverprogramming.project;

import com.serverprogramming.project.domain.Category;
import com.serverprogramming.project.domain.Event;
import com.serverprogramming.project.domain.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DBTest {
    @Autowired
    private EventRepository eventRepository;
    @Test
    public void findAllByDateShouldReturnAUser(){
        List<Event> events = eventRepository.findAllByDate(LocalDate.of(2021, 12, 31));
        assertThat(events.get(0).getUsername()).isEqualTo("1");
    }
    @Test
    public void createNewEvent(){
        Event event = new Event(LocalTime.of(15, 00), "Test test event", LocalDate.of(2021, 05, 03), "2", new Category("Test category"));
        eventRepository.save(event);
        assertThat(event.getId()).isNotNull();
    }
}
