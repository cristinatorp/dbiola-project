package IKT446.dbiola.repository;

import IKT446.dbiola.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Long> {

    List<Movie> findAll();

}
