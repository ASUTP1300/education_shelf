package edu.spring_wf.controller;

import edu.spring_wf.data.dto.PersonDto;
import edu.spring_wf.data.entity.Person;
import edu.spring_wf.data.repository.PersonRepository;
import edu.spring_wf.data.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/persons")
public class PersonController {

    final AtomicInteger counter = new AtomicInteger(0);
    private final PersonRepository repository;
    private final PersonService service;

    private volatile PersonDto dto;

    public PersonController(PersonRepository repository, PersonService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/mono/{id}")
    public Mono<Person> getPersonById(@PathVariable int id) {
        Mono<Person> person = Mono.just(repository.findById(id).orElseThrow(() -> new RuntimeException("Такого человека нет!!")));
        System.out.println("Person " + person);
        return person;
    }

    @GetMapping("/{id}")
    public Person getPersonByIdType(@PathVariable int id) {
        Person person = repository.findById(id).orElseThrow(() -> new RuntimeException("Такого человека нет!!"));
        System.out.println("Person " + person);
        System.out.println("Был вызван N : " + counter.addAndGet(1) + " раз. Время: " + LocalDateTime.now());
        return person;
    }

    @GetMapping
    public Flux<Person> getAllPerson() {
        Iterable<Person> persons = repository.findAll();
        return Flux.fromIterable(persons);
    }

    @PostMapping (produces = {"application/json"})
    public void createPerson(PersonDto personDto){
        this.dto = personDto;
        service.create(personDto);
    }

    //Держим клиента пока создадим Person
    @GetMapping(
            value = "/new",
            produces = "application/json"
    )
    public ResponseEntity<PersonDto> getNewPerson() throws InterruptedException {

        while (Objects.isNull(dto)) {}
        return ResponseEntity.ok(dto);
    }

}


