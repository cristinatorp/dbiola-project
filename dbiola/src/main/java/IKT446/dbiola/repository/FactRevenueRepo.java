package IKT446.dbiola.repository;

import IKT446.dbiola.model.FactRevenue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactRevenueRepo extends CrudRepository<FactRevenue, Long> {

    List<FactRevenue> findAll();

}
