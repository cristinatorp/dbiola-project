package IKT446.dbiola.api;

import IKT446.dbiola.repository.CrewMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crew_member")
public class CrewMemberController {

    private final CrewMemberRepo crewMemberRepo;

    @Autowired
    public CrewMemberController(CrewMemberRepo crewMemberRepo) {
        this.crewMemberRepo = crewMemberRepo;
    }

}
