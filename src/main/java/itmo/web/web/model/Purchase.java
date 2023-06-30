package itmo.web.web.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@Data
@RequestScope
public class Purchase {
   private String name;
    private double cash;
}
