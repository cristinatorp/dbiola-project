package IKT446.dbiola.repository;

import IKT446.dbiola.model.MovieKeyword;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieKeywordRepo extends CrudRepository<MovieKeyword, Long> {

    List<MovieKeyword> findAll();

}
