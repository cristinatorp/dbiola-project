package IKT446.dbiola.repository;

import IKT446.dbiola.model.SpokenLanguage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpokenLanguageRepo extends CrudRepository<SpokenLanguage, Long> {

    List<SpokenLanguage> findAll();

    Optional<SpokenLanguage> findByCode(String code);

}
