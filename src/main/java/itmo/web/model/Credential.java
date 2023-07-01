package itmo.web.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;


@Data
public class Credential {
    @Id
    private int id;
    private String name;
    private BigDecimal money;

    public void subtract(BigDecimal cash) {
        if (money.subtract(cash).compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new NotEnoughMoneyException(id);
        }
        money = money.subtract(cash);
    }

    public void addMoney(BigDecimal cash) {
        money = money.add(cash);
    }

}
