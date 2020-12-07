package IKT446.dbiola.api;

import IKT446.dbiola.repository.KeywordRepo;
import IKT446.dbiola.repository.MovieKeywordRepo;
import IKT446.dbiola.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie/keyword")
public class MovieKeywordController {

    private final MovieKeywordRepo movieKeywordRepo;
    private final MovieRepo movieRepo;
    private final KeywordRepo keywordRepo;

    @Autowired
    public MovieKeywordController(MovieKeywordRepo movieKeywordRepo,
                                  MovieRepo movieRepo,
                                  KeywordRepo keywordRepo) {
        this.movieKeywordRepo = movieKeywordRepo;
        this.movieRepo = movieRepo;
        this.keywordRepo = keywordRepo;
    }

}
