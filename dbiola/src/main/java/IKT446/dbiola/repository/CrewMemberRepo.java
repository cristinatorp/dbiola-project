package IKT446.dbiola.repository;

import IKT446.dbiola.model.CrewMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrewMemberRepo extends CrudRepository<CrewMember, Long> {

    List<CrewMember> findAll();

}
