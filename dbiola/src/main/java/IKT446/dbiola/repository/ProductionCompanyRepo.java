package IKT446.dbiola.repository;

import IKT446.dbiola.model.ProductionCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionCompanyRepo extends CrudRepository<ProductionCompany, Long> {

    List<ProductionCompany> findAll();

}
