package itmo.web.controller;

import itmo.web.model.TransferRequest;
import itmo.web.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TransferController {
    private TransferService transferService;

    @PostMapping()
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequest transferRequest) {
        transferService.transferMoney(transferRequest.getIdSender(), transferRequest.getIdReceiver(), transferRequest.getMoney());
        return ResponseEntity.accepted().body("transfer succeed");
    }


}
