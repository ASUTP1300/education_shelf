package edu.spring_wf.data.entity;

import org.hibernate.annotations.Entity;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Table(schema = "test", name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TestPersonSequence" )
    @SequenceGenerator(
            schema = "test",
            name = "TestPersonSequence",
            sequenceName = "person_seq",
            allocationSize = 1
    )
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    @Column(name = "birthdate")
    private LocalDateTime birthDate;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
