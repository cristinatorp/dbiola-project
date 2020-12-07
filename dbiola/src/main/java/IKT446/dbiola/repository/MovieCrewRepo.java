package IKT446.dbiola.repository;

import IKT446.dbiola.model.MovieCrew;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieCrewRepo extends CrudRepository<MovieCrew, Long> {

    List<MovieCrew> findAll();

    List<MovieCrew> findByMovieId(Long movieId);

}
