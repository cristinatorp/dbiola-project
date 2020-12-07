package IKT446.dbiola.repository;

import IKT446.dbiola.model.MovieProdCountry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieProdCountryRepo extends CrudRepository<MovieProdCountry, Long> {

    List<MovieProdCountry> findAll();

    List<MovieProdCountry> findByMovieId(Long movieId);

}
