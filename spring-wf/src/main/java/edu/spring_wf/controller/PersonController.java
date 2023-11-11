package edu.spring_wf.controller;

import edu.spring_wf.data.entity.Person;
import edu.spring_wf.data.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Mono<Person> getPersonById(@PathVariable int id) {
        return Mono.just(repository.findById(id).orElseThrow(() -> new RuntimeException("Такого человека нет!!")));
    }

    @GetMapping
    public Flux<Person> getAllPerson() {
        Iterable<Person> persons = repository.findAll();
        return Flux.fromIterable(persons);
    }

}
