package IKT446.dbiola.repository;

import IKT446.dbiola.model.DimMovie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DimMovieRepo extends CrudRepository<DimMovie, Long> {

    List<DimMovie> findAll();

}
