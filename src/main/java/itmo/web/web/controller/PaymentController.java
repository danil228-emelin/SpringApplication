package itmo.web.web.controller;

import itmo.web.web.model.Purchase;
import itmo.web.web.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PaymentController {
    private PaymentService paymentService;

    @GetMapping()
    public ResponseEntity<String> buy(@RequestBody Purchase purchase) {
        paymentService.checkPayment(purchase);
        return ResponseEntity.accepted().body("sold");
    }
}
