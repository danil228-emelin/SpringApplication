package itmo.web.repository;

import itmo.web.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Repository

@ApplicationScope
public class PurchaseRepository {
    private final JdbcTemplate template;

    public PurchaseRepository(JdbcTemplate template) {
        this.template = template;
    }

    public void saveElement(Purchase purchase) {
        String sql = "insert into purchase values(?,?,?)";
        template.update(sql, purchase.getId(), purchase.getCost(), purchase.getProduct());
    }

    public List<Purchase> findAll() {
        String sql = "Select * from purchase";
        RowMapper<Purchase> rowMapper = (r, i) -> {
            var purchase = new Purchase();
            purchase.setId(r.getInt("id"));
            purchase.setCost(r.getBigDecimal("cost"));
            purchase.setProduct(r.getString("name"));
            return purchase;
        };
        return template.query(sql, rowMapper);
    }

}
