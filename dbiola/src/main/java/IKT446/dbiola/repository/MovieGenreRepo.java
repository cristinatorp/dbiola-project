package IKT446.dbiola.repository;

import IKT446.dbiola.model.MovieGenre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieGenreRepo extends CrudRepository<MovieGenre, Long> {

    List<MovieGenre> findAll();

    List<MovieGenre> findByMovieId(Long movieId);

}
