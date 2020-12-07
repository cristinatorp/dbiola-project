package IKT446.dbiola.repository;

import IKT446.dbiola.model.DimCountry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DimCountryRepo extends CrudRepository<DimCountry, Long> {

    List<DimCountry> findAll();

}
