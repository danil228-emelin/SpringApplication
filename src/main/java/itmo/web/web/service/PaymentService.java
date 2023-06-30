package itmo.web.web.service;

import itmo.web.web.model.NotEnoughMoneyException;
import itmo.web.web.model.Purchase;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class PaymentService {

    public boolean checkPayment(Purchase purchase) {
        if (purchase.getCash() <30) {
            throw new NotEnoughMoneyException();
        }
        return true;
    }
}
