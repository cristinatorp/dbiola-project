package IKT446.dbiola.repository;

import IKT446.dbiola.model.Keyword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeywordRepo extends CrudRepository<Keyword, Long> {
    List<Keyword> findAll();
}
