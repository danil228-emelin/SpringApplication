package itmo.web.model;

public class NotEnoughMoneyException  extends RuntimeException{
    public NotEnoughMoneyException(int id){
        super(String.format("element with %d doesn't have enough money for transaction", id));
    }

}
