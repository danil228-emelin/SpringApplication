package itmo.web.web.service;

import itmo.web.web.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Server {
    private List<Person> list = new ArrayList<>();

    public void add(Person person) {
        list.add(person);
    }

    public boolean contains(Person person) {
        return list.contains(person);
    }

}
