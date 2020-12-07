package IKT446.dbiola.repository;

import IKT446.dbiola.model.DimCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DimCompanyRepo extends CrudRepository<DimCompany, Long> {

    List<DimCompany> findAll();

}
