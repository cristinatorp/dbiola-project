package IKT446.dbiola.repository;

import IKT446.dbiola.model.MovieCast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieCastRepo extends CrudRepository<MovieCast, Long> {

    List<MovieCast> findAll();

    List<MovieCast> findByMovieId(Long movieId);

}
