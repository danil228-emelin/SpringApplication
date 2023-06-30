package itmo.web.web.controller;

import itmo.web.web.model.Person;
import itmo.web.web.service.Server;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/people", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {
    private Server server;

    @PostMapping()
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        server.add(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);

    }
}
