package IKT446.dbiola.api;

import IKT446.dbiola.model.Movie;
import IKT446.dbiola.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieRepo movieRepo;

    @Autowired
    public MovieController(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

}
