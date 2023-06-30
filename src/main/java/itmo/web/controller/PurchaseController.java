package itmo.web.controller;

import itmo.web.model.Purchase;
import itmo.web.repository.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PurchaseController {
    private PurchaseRepository purchaseRepository;

    @GetMapping
    public ResponseEntity<List<Purchase>> findAll() {
        return ResponseEntity.accepted().body(purchaseRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<String> addElement(@RequestBody Purchase purchase) {
        purchaseRepository.saveElement(purchase);
        return ResponseEntity.accepted().body("Element saved");
    }

}
