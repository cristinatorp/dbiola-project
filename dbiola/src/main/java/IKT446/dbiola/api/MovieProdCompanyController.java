package IKT446.dbiola.api;

import IKT446.dbiola.repository.MovieProdCompanyRepo;
import IKT446.dbiola.repository.MovieRepo;
import IKT446.dbiola.repository.ProductionCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie/prod_company")
public class MovieProdCompanyController {

    private final MovieProdCompanyRepo movieCompanyRepo;
    private final MovieRepo movieRepo;
    private final ProductionCompanyRepo companyRepo;

    @Autowired
    public MovieProdCompanyController(MovieProdCompanyRepo movieCompanyRepo,
                                      MovieRepo movieRepo,
                                      ProductionCompanyRepo companyRepo) {
        this.movieCompanyRepo = movieCompanyRepo;
        this.movieRepo = movieRepo;
        this.companyRepo = companyRepo;
    }

}
