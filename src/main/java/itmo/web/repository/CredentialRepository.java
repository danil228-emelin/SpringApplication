package itmo.web.repository;

import itmo.web.model.Credential;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface CredentialRepository extends CrudRepository<Credential, Integer> {
    Credential findById(int id);

    @Modifying
    @Query("UPDATE credential set money= :cash where credential.id = :id")
    void changeMoney(BigDecimal cash, int id);
}
