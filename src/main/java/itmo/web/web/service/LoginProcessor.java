package itmo.web.web.service;

import itmo.web.web.model.Person;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Data
public class LoginProcessor {
    private Server server;
    private String userName;
    private String password;

    @Autowired
    public LoginProcessor(Server server) {
        this.server = server;
    }

    public String verifyString() {
        Person person = new Person();
        person.setLogin(userName);
        person.setLogin(password);
        if (server.contains(person)) {
            return "Login failed";
        }
        server.add(person);
        return "Login succeed";
    }

    public boolean verifyBoolean() {
        Person person = new Person();
        person.setLogin(userName);
        person.setLogin(password);
        if (server.contains(person)) {
            return false;
        }
        server.add(person);
        return true;
    }

}
