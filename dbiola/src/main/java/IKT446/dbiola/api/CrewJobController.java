package IKT446.dbiola.api;

import IKT446.dbiola.repository.CrewJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crew_job")
public class CrewJobController {

    private final CrewJobRepo jobRepo;

    @Autowired
    public CrewJobController(CrewJobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

}
