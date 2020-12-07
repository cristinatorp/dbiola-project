package IKT446.dbiola.api;

import IKT446.dbiola.repository.MovieRepo;
import IKT446.dbiola.repository.MovieSpokenLanguageRepo;
import IKT446.dbiola.repository.SpokenLanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie/language")
public class MovieSpokenLanguageController {

    private final MovieSpokenLanguageRepo movieLanguageRepo;
    private final MovieRepo movieRepo;
    private final SpokenLanguageRepo languageRepo;

    @Autowired
    public MovieSpokenLanguageController(MovieSpokenLanguageRepo movieLanguageRepo,
                                         MovieRepo movieRepo,
                                         SpokenLanguageRepo languageRepo) {
        this.movieLanguageRepo = movieLanguageRepo;
        this.movieRepo = movieRepo;
        this.languageRepo = languageRepo;
    }

}
