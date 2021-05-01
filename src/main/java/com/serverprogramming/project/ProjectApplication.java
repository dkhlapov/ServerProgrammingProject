package com.serverprogramming.project;

import com.serverprogramming.project.domain.Category;
import com.serverprogramming.project.domain.CategoryRepository;
import com.serverprogramming.project.domain.Event;
import com.serverprogramming.project.domain.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner eventDemo(EventRepository eventRepository, CategoryRepository categoryRepository){
        return args -> {
            categoryRepository.save(new Category("Work"));
            categoryRepository.save(new Category("Study"));
            categoryRepository.save(new Category("Shopping"));
            categoryRepository.save(new Category("Groceries"));
            categoryRepository.save(new Category("Meeting"));

            eventRepository.save(new Event("12:30", "Test event", "2021-12-31", "1", categoryRepository.findCategoryByName("Meeting").get(0)));
        };
    }
}
