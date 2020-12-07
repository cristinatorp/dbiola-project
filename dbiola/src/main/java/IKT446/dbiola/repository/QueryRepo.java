package IKT446.dbiola.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Repository
public class QueryRepo {

    @PersistenceContext
    private EntityManager em;

    public List<Map<String, Object>> findByQuery(String queryString, JdbcTemplate template) {
        return template.queryForList(queryString);
    }
}
