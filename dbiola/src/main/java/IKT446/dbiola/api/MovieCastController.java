package IKT446.dbiola.api;

import IKT446.dbiola.repository.ActorRepo;
import IKT446.dbiola.repository.MovieCastRepo;
import IKT446.dbiola.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cast")
public class MovieCastController {

    private final MovieCastRepo castRepo;
    private final MovieRepo movieRepo;
    private final ActorRepo actorRepo;

    @Autowired
    public MovieCastController(MovieCastRepo castRepo, MovieRepo movieRepo, ActorRepo actorRepo) {
        this.castRepo = castRepo;
        this.movieRepo = movieRepo;
        this.actorRepo = actorRepo;
    }

}
