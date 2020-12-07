package IKT446.dbiola.api;

import IKT446.dbiola.repository.CrewJobRepo;
import IKT446.dbiola.repository.CrewMemberRepo;
import IKT446.dbiola.repository.MovieCrewRepo;
import IKT446.dbiola.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crew")
public class MovieCrewController {

    private final MovieCrewRepo crewRepo;
    private final MovieRepo movieRepo;
    private final CrewMemberRepo crewMemberRepo;
    private final CrewJobRepo jobRepo;

    @Autowired
    public MovieCrewController(MovieCrewRepo crewRepo,
                               MovieRepo movieRepo,
                               CrewMemberRepo crewMemberRepo,
                               CrewJobRepo jobRepo) {
        this.crewRepo = crewRepo;
        this.movieRepo = movieRepo;
        this.crewMemberRepo = crewMemberRepo;
        this.jobRepo = jobRepo;
    }

}
