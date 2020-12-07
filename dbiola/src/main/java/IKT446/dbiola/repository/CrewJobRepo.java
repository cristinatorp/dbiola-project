package IKT446.dbiola.repository;

import IKT446.dbiola.model.CrewJob;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrewJobRepo extends CrudRepository<CrewJob, Long> {

    List<CrewJob> findAll();

    Optional<CrewJob> findByJobAndDepartment(String jobTitle, String department);

}
