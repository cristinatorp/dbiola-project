package IKT446.dbiola.repository;

import IKT446.dbiola.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepo extends CrudRepository<Genre, Long> {

    List<Genre> findAll();

}