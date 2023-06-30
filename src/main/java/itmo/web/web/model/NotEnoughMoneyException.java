package itmo.web.web.model;

public class NotEnoughMoneyException extends RuntimeException {

    public NotEnoughMoneyException() {
        super("Not enough money bla");
    }
}
