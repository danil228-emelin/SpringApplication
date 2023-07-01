package itmo.web.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.math.BigDecimal;

@Component
@RequestScope
@Data
public class TransferRequest {
    private int idSender;
    private int idReceiver;
    private BigDecimal money;
}
