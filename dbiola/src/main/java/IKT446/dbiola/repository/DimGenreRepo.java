package IKT446.dbiola.repository;

import IKT446.dbiola.model.DimGenre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DimGenreRepo extends CrudRepository<DimGenre, Long> {

    List<DimGenre> findAll();

}
