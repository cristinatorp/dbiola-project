package IKT446.dbiola.repository;

import IKT446.dbiola.model.ProductionCountry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductionCountryRepo extends CrudRepository<ProductionCountry, Long> {

    List<ProductionCountry> findAll();

    Optional<ProductionCountry> findByCode(String code);

}
