package com.serverprogramming.project.web;


import com.serverprogramming.project.domain.CategoryRepository;
import com.serverprogramming.project.domain.Event;
import com.serverprogramming.project.domain.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalendarController {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value={"/", "eventlist"})
    public String eventList(Model model){
        model.addAttribute("events", eventRepository.findAll());
        return "eventlist";
    }

    @GetMapping("/add")
    public String addEvent(Model model){
        model.addAttribute("event", new Event());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addevent";
    }

    @PostMapping("save")
    public String saveEvent(Event event){
        eventRepository.save(event);
        return "redirect:eventlist";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long eventId, Model model){
        eventRepository.deleteById(eventId);
        return "redirect:../eventlist";
    }

    @GetMapping("/edit/{id}")
    public String editEvent(@PathVariable("id") Long eventId, Model model){
        model.addAttribute("event", eventRepository.findById(eventId));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editevent";
    }
}
