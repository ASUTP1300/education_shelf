package edu.spring_wf.data.service.impl;

import edu.spring_wf.data.dto.PersonDto;
import edu.spring_wf.data.entity.Person;
import edu.spring_wf.data.service.PersonService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Service
public class PersonServiceImpl implements PersonService {
    @PersistenceContext
    private final EntityManager entityManager;

    public PersonServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void create(PersonDto dto) {
        internalCreate(dto.name(), dto.age());

        System.out.println("Таблица Person");
        TypedQuery<Person> query = entityManager.createQuery("select P from Person P", Person.class);
        query.getResultList().forEach(System.out::println);
        System.out.println("Конец");
    }

    public void internalCreate(String name, int age) {
        Person person = new Person();

        person.setName(name);
        person.setAge(age);

        entityManager.persist(person);
    }
}
