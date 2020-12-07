package IKT446.dbiola.api;

import IKT446.dbiola.model.FactRevenue;
import IKT446.dbiola.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fact")
public class FactRevenueController<T> {

    private final FactRevenueRepo factRepo;
    private final QueryRepo queryRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FactRevenueController(FactRevenueRepo factRepo, QueryRepo queryRepo) {
        this.factRepo = factRepo;
        this.queryRepo = queryRepo;
    }

    @GetMapping
    public List<FactRevenue> getFacts() {
        return factRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/query")
    public List<Map<String, Object>> findByQuery(@RequestBody String query) {
        return queryRepo.findByQuery(query, jdbcTemplate);
    }

}
