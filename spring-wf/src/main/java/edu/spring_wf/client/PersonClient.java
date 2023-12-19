package edu.spring_wf.client;

import edu.spring_wf.data.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
        name = "file",
        url = "http://localhost:9166/"
)
public interface PersonClient {
    @GetMapping(value = "/persons/{id}")
    ResponseEntity<Person> getById(@PathVariable("id") Integer id);
}
