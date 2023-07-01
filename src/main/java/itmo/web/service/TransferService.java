package itmo.web.service;

import itmo.web.model.Credential;
import itmo.web.model.NoAccountException;
import itmo.web.repository.CredentialRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.ApplicationScope;

import java.math.BigDecimal;

@Service
@ApplicationScope
@NoArgsConstructor
public class TransferService {
    private CredentialRepository repository;

    @Autowired
    public TransferService(CredentialRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void transferMoney(int idSender, int idReceiver, BigDecimal money) {
        Credential sender = repository.findById(idSender);
        if (sender == null) {
            throw new NoAccountException(idSender);
        }
        Credential receiver = repository.findById(idReceiver);
        if (receiver == null) {
            throw new NoAccountException(idReceiver);
        }
        sender.subtract(money);

        receiver.addMoney(money);
        repository.changeMoney(sender.getMoney(),idSender);
        repository.changeMoney(receiver.getMoney(),idReceiver);
    }
}
