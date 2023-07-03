package itmo.web.service;

import itmo.web.model.Credential;
import itmo.web.model.NoAccountException;
import itmo.web.model.NotEnoughMoneyException;
import itmo.web.repository.CredentialRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransferServiceTests {
    @Mock
     CredentialRepository repository;
    @InjectMocks
     TransferService transferService;

    @Test
    @DisplayName("Test transaction succeed")
    void SuccessfulTransferMoney() {
        Credential sender = new Credential();
        sender.setId(1);
        sender.addMoney(BigDecimal.valueOf(300));
        Credential receiver = new Credential();
        receiver.setId(2);
        receiver.addMoney(BigDecimal.valueOf(300));
        given(repository.findById(sender.getId())).
                willReturn(sender);
        given(repository.findById(receiver.getId()))
                .willReturn(receiver);
        transferService.transferMoney(1, 2, BigDecimal.valueOf(10));

        verify(repository)
                .changeMoney(BigDecimal.valueOf(290), 1);
        verify(repository)
                .changeMoney(BigDecimal.valueOf(310), 2);
    }

    @Test
    @DisplayName("Transaction throw NotEnoughMoneyException")
    void TransferMoneyNotEnoughMoney() {
        Credential sender = new Credential();
        sender.setId(1);
        sender.setMoney(BigDecimal.valueOf(0));
        Credential receiver = new Credential();
        receiver.setId(2);
        sender.setMoney(BigDecimal.valueOf(0));
        given(repository.findById(sender.getId())).
                willReturn(sender);
        given(repository.findById(receiver.getId()))
                .willReturn(receiver);
        assertThrows(NotEnoughMoneyException.class,
                () -> transferService.transferMoney(1, 2, BigDecimal.valueOf(10)));
        verify(repository, never()).changeMoney(BigDecimal.valueOf(-10), 1);
        verify(repository, never()).changeMoney(BigDecimal.valueOf(10), 2);

    }

    @Test
    @DisplayName("Transaction throw NoAccountException")
    void TransferMoneyNoAccountException() {
        when(repository.findById(1)).thenReturn(null);
        assertThrows(NoAccountException.class,
                () -> transferService.transferMoney(1, 2, BigDecimal.valueOf(10)));

    }

}
