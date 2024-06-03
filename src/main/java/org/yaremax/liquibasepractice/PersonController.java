package org.yaremax.liquibasepractice;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
@AllArgsConstructor
public class PersonController {
    private PersonRepository personRepository;

    @PostMapping
    public String createPerson(@RequestParam String name) {
        return personRepository.save(Person.builder().name(name).build()).toString();
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(personRepository.findAll());
    }
}
