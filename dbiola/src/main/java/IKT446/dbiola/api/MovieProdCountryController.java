package IKT446.dbiola.api;

import IKT446.dbiola.repository.MovieProdCountryRepo;
import IKT446.dbiola.repository.MovieRepo;
import IKT446.dbiola.repository.ProductionCountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie/prod_country")
public class MovieProdCountryController {

    private final MovieProdCountryRepo movieProdCountryRepo;
    private final MovieRepo movieRepo;
    private final ProductionCountryRepo countryRepo;

    @Autowired
    public MovieProdCountryController(MovieProdCountryRepo movieProdCountryRepo,
                                      MovieRepo movieRepo,
                                      ProductionCountryRepo countryRepo) {
        this.movieProdCountryRepo = movieProdCountryRepo;
        this.movieRepo = movieRepo;
        this.countryRepo = countryRepo;
    }

}
