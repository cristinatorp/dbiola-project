package IKT446.dbiola.repository;

import IKT446.dbiola.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepo extends CrudRepository<Actor, Long> {

    List<Actor> findAll();

    Actor findByName(String name);

}
