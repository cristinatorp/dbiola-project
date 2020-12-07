package IKT446.dbiola.repository;

import IKT446.dbiola.model.MovieProdCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieProdCompanyRepo extends CrudRepository<MovieProdCompany, Long> {

    List<MovieProdCompany> findAll();

    List<MovieProdCompany> findByMovieId(Long movieId);

}
