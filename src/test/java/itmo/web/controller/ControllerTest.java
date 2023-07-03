package itmo.web.controller;

import itmo.web.model.NoAccountException;
import itmo.web.model.TransferRequest;
import itmo.web.service.TransactionExceptionHandler;
import itmo.web.service.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ControllerTest {
    @MockBean
    TransactionExceptionHandler transactionExceptionHandler;
    @MockBean
    TransferService transferService;
    @Autowired
    TransferController transferController;

    @DisplayName("transferMoneySuccess succeed")
    @Test
    void transferMoneySuccess() {
        TransferRequest transferRequest = new TransferRequest();
        ResponseEntity<String> response = transferController.transferMoney(transferRequest);
        assertEquals(response.getBody(), "transfer succeed");
    }


}
