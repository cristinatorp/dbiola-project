package IKT446.dbiola.repository;

import IKT446.dbiola.model.MovieSpokenLanguage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieSpokenLanguageRepo extends CrudRepository<MovieSpokenLanguage, Long> {

    List<MovieSpokenLanguage> findAll();

    List<MovieSpokenLanguage> findByMovieId(Long movieId);

}
