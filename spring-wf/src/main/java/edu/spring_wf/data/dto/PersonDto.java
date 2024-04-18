package edu.spring_wf.data.dto;

import java.time.LocalDateTime;

public record PersonDto(String name, int age, LocalDateTime birthDate) {
}
