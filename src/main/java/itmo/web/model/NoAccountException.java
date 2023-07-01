package itmo.web.model;

public class NoAccountException extends RuntimeException {
    public NoAccountException(int id) {
        super(String.format("There is no account with id %d", id));
    }
}
